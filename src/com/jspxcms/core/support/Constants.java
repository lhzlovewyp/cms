package com.jspxcms.core.support;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.jspxcms.common.util.ConstantConfigurer;

/**
 * CMS常量
 * 
 * @author liufang
 * 
 */
public class Constants implements ConstantConfigurer {
	/**
	 * 当前版本
	 */
	public static final String VERSION = "5.2.4";
	/**
	 * Quartz中使用的ApplicationContext
	 */
	public static final String APP_CONTEXT = "appContext";

	public static final String VERIFY_MEMBER_TYPE = "verify_member";
	public static final String VERIFY_MEMBER_URL = "/verify_member.jspx?key=";
	public static final String RETRIEVE_PASSWORD_TYPE = "retrieve_password";
	public static final String RETRIEVE_PASSWORD_URL = "/retrieve_password.jspx?key=";
	/**
	 * 内容访问路径
	 */
	public static final String INFO_PATH = "info";
	/**
	 * 栏目访问路径
	 */
	public static final String NODE_PATH = "node";
	/**
	 * 动态也后缀
	 */
	public static final String DYNAMIC_SUFFIX = ".jspx";
	/**
	 * 站点前缀
	 */
	public static final String SITE_PREFIX = "/site_";
	/**
	 * 上下文路径
	 */
	public static final String CTX = "ctx";
	/**
	 * 页面操作状态
	 */
	public static final String OPRT = "oprt";
	/**
	 * 新增状态
	 */
	public static final String CREATE = "create";
	/**
	 * 编辑状态
	 */
	public static final String EDIT = "edit";
	/**
	 * 查看状态
	 */
	public static final String VIEW = "view";
	/**
	 * 重定向至修改页面
	 */
	public static final String REDIRECT_EDIT = "edit";
	/**
	 * 重定向至查看页面
	 */
	public static final String REDIRECT_VIEW = "view";
	/**
	 * 重定向至列表页面
	 */
	public static final String REDIRECT_LIST = "list";
	/**
	 * 重定向至新增页面
	 */
	public static final String REDIRECT_CREATE = "create";
	/**
	 * 搜索字符串前缀
	 */
	public static final String SEARCH_PREFIX = "search_";
	/**
	 * 搜索字符串
	 */
	public static final String SEARCH_STRING = "searchstring";
	/**
	 * 搜索字符串（不含排序）
	 */
	public static final String SEARCH_STRING_NO_SORT = "searchstringnosort";
	/**
	 * 身份识别COOKIE名称
	 */
	public static final String IDENTITY_COOKIE_NAME = "_jspxcms";

	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static final String OPERATION_SUCCESS = "operationSuccess";
	public static final String OPERATION_FAILURE = "operationFailure";
	public static final String SAVE_SUCCESS = "saveSuccess";
	public static final String DELETE_SUCCESS = "deleteSuccess";

	public static final String USER_ANGENT = "Mozilla/5.0";

	public static String LOGIN_URL = "/login.jspx";
	public static String TEMPLATE_STORE_PATH = "/template";
	public static String TEMPLATE_DISPLAY_PATH = "/template";
	public static String STATIC_DISPLAY_PATH = "/static";
	public static String OPENOFFICE_HOST = null;
	public static int OPENOFFICE_PORT = -1;
	public static String SWFTOOLS_PDF2SWF = null;
	public static boolean IS_ROOT_ALL_PERMS = false;
	public static String CMSCP = "/cmscp";
	public static String BACK_SUCCESS_URL = "/cmscp/index.do";
	public static String BACK_LOGIN_URL = "/cmscp/login.do";
	public static String DEF_USERNAME = "";
	public static String DEF_PASSWORD = "";

	public void loadProperties(Properties properties) {
		if (properties == null) {
			return;
		}
		String loginUrl = properties.getProperty("loginUrl");
		if (loginUrl != null) {
			LOGIN_URL = loginUrl;
		}
		String templateStorePath = properties.getProperty("templateStorePath");
		if (templateStorePath != null) {
			TEMPLATE_STORE_PATH = templateStorePath;
		}
		String templateDisplayPath = properties
				.getProperty("templateDisplayPath");
		if (templateDisplayPath != null) {
			TEMPLATE_DISPLAY_PATH = templateDisplayPath;
		}
		String staticDisplayPath = properties.getProperty("staticDisplayPath");
		if (staticDisplayPath != null) {
			STATIC_DISPLAY_PATH = staticDisplayPath;
		}
		String openofficeHost = properties.getProperty("openofficeHost");
		if (openofficeHost != null) {
			OPENOFFICE_HOST = openofficeHost;
		}
		String openofficePort = properties.getProperty("openofficePort");
		if (StringUtils.isNotBlank(openofficePort)) {
			OPENOFFICE_PORT = Integer.valueOf(openofficePort);
		}
		String swftoolsPdf2swf = properties.getProperty("swftoolsPdf2swf");
		if (swftoolsPdf2swf != null) {
			SWFTOOLS_PDF2SWF = swftoolsPdf2swf;
		}
		String isRootAllPerms = properties.getProperty("isRootAllPerms");
		if ("true".equals(isRootAllPerms)) {
			IS_ROOT_ALL_PERMS = true;
		}
		String cmscp = properties.getProperty("cmscp");
		if (cmscp != null) {
			CMSCP = cmscp;
		}
		String backSuccessUrl = properties.getProperty("backSuccessUrl");
		if (backSuccessUrl != null) {
			BACK_SUCCESS_URL = backSuccessUrl;
		}
		String backLoginUrl = properties.getProperty("backLoginUrl");
		if (backLoginUrl != null) {
			BACK_LOGIN_URL = backLoginUrl;
		}
		String defUsername = properties.getProperty("defUsername");
		if (defUsername != null) {
			DEF_USERNAME = defUsername;
		}
		String defPassword = properties.getProperty("defPassword");
		if (defPassword != null) {
			DEF_PASSWORD = defPassword;
		}
	}
}
