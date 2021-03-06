package com.jspxcms.ext.web.back;

import static com.jspxcms.core.support.Constants.DELETE_SUCCESS;
import static com.jspxcms.core.support.Constants.MESSAGE;
import static com.jspxcms.core.support.Constants.SAVE_SUCCESS;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jspxcms.core.support.Context;
import com.jspxcms.ext.domain.FriendlinkType;
import com.jspxcms.ext.service.FriendlinkTypeService;

/**
 * FriendlinkTypeController
 * 
 * @author yangxing
 * 
 */
@Controller
@RequestMapping("/ext/friendlink_type")
public class FriendlinkTypeController {
	private static final Logger logger = LoggerFactory.getLogger(FriendlinkTypeController.class);

	@RequiresPermissions("ext:friendlink_type:list")
	@RequestMapping("list.do")
	public String list(HttpServletRequest request,org.springframework.ui.Model modelMap) {
		Integer siteId = Context.getCurrentSiteId(request);
		List<FriendlinkType> list = service.findList(siteId);
		modelMap.addAttribute("list", list);
		return "ext/friendlink_type/friendlink_type_list";
	}

	@RequiresPermissions("ext:friendlink_type:save")
	@RequestMapping("save.do")
	public String save(FriendlinkType bean, String redirect,
			HttpServletRequest request, RedirectAttributes ra) {
		Integer siteId = Context.getCurrentSiteId(request);
		service.save(bean, siteId);
		logger.info("save FriendlinkType, name={}.", bean.getName());
		ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
		return "redirect:list.do";
	}

	@RequiresPermissions("ext:friendlink_type:batch_update")
	@RequestMapping("batch_update.do")
	public String batchUpdate(Integer[] id, String[] name, String[] number, RedirectAttributes ra) {
		if (ArrayUtils.isNotEmpty(id)) {
			FriendlinkType[] beans = service.batchUpdate(id, name, number);
			for (FriendlinkType bean : beans) {
				logger.info("update FriendlinkType, name={}.", bean.getName());
			}
		}
		ra.addFlashAttribute(MESSAGE, SAVE_SUCCESS);
		return "redirect:list.do";
	}

	@RequiresPermissions("ext:friendlink_type:delete")
	@RequestMapping("delete.do")
	public String delete(Integer[] ids, RedirectAttributes ra) {
		FriendlinkType[] beans = service.delete(ids);
		for (FriendlinkType bean : beans) {
			logger.info("delete FriendlinkType, name={}.", bean.getName());
		}
		ra.addFlashAttribute(MESSAGE, DELETE_SUCCESS);
		return "redirect:list.do";
	}

	@Autowired
	private FriendlinkTypeService service;
}
