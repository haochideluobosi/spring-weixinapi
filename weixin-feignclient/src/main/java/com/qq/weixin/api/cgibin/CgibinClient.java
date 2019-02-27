package com.qq.weixin.api.cgibin;


import com.qq.weixin.api.BaseResponse;
import com.qq.weixin.api.cgibin.request.ApiComponentTokenRequest;
import com.qq.weixin.api.cgibin.request.ComponentFastregisterweappRequest;
import com.qq.weixin.api.cgibin.request.MenuButtonsRequest;
import com.qq.weixin.api.cgibin.request.QrcodeCreateRequest;
import com.qq.weixin.api.cgibin.response.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "cgi-bin", url = "https://api.weixin.qq.com/cgi-bin/")
public interface CgibinClient {
    /**
     * 获取全局AccessToken接口
     *
     * @param appid
     * @param secret
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183}
     */
    @RequestMapping(value = "/token?grant_type=client_credential", method = RequestMethod.GET)
    GlobalTokenResponse token(@RequestParam("appid") String appid, @RequestParam("secret") String secret);

    @RequestMapping(value = "/component/api_component_token", method = RequestMethod.POST)
    ApiComponentTokenResponse componentApiComponentToken(@RequestBody ApiComponentTokenRequest apiComponentTokenRequest);

    /**
     * 创建小程序接口
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=create", method = RequestMethod.POST)
    BaseResponse componentFastregisterweappCreate(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);

    /**
     * 查询创建任务状态
     *
     * @param componentFastregisterweappRequest
     * @return
     */
    @RequestMapping(value = "/component/fastregisterweapp?action=search", method = RequestMethod.POST)
    BaseResponse componentFastregisterweappSearch(@RequestParam("component_access_token") String componentAccessToken, @RequestBody ComponentFastregisterweappRequest componentFastregisterweappRequest);


    /**
     * 自定义菜单创建接口
     *
     * @param accessToken
     * @param menuButtons
     * @return
     */
    @RequestMapping(value = "/menu/create", method = RequestMethod.POST)
    BaseResponse menuCreate(@RequestParam("access_token") String accessToken, @RequestBody MenuButtonsRequest menuButtons);

    /**
     * 自定义菜单删除接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/delete", method = RequestMethod.GET)
    BaseResponse menuDelete(@RequestParam("access_token") String accessToken);

    /**
     * 自定义菜单查询接口
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/menu/get", method = RequestMethod.GET)
    MenuResponse menuGet(@RequestParam("access_token") String accessToken);


    /**
     * 个性化菜单接口
     *
     * @param accessToken
     * @param menu
     * @return
     */
    @RequestMapping(value = "/menu/addconditional", method = RequestMethod.POST)
    BaseResponse menuAddconditional(@RequestParam("access_token") String accessToken, @RequestBody MenuResponse menu);

    /**
     * 生成带参数的二维码
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1443433542}
     */
    @RequestMapping(value = "/qrcode/create", method = RequestMethod.POST)
    QrcodeTicketResponse qrcodeCreate(@RequestParam("access_token") String accessToken, @RequestBody QrcodeCreateRequest qrcodeCreateRequest);

    /**
     * JS-SDK使用权限签名算法
     *
     * @param accessToken
     * @return
     * @link {https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115}
     */
    @RequestMapping(value = "/ticket/getticket?type=jsapi", method = RequestMethod.GET)
    JsapiTicketResponse ticketGetticket(@RequestParam("access_token") String accessToken);

    /**
     * 获取帐号基本信息
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/getaccountbasicinfo", method = RequestMethod.POST)
    BaseResponse accountGetaccountbasicinfo(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 修改头像
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/modifyheadimage", method = RequestMethod.POST)
    BaseResponse accountModifyheadimage(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 跳转至第三方平台，第三方平台调用快速注册API完成管理员换绑。
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/componentrebindadmin", method = RequestMethod.POST)
    BaseResponse accountComponentrebindadmin(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 修改功能介绍
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/modifysignature", method = RequestMethod.POST)
    BaseResponse accountModifysignature(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 跳转至第三方平台，第三方平台调用快速注册API完成注册
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "/account/fastregister", method = RequestMethod.POST)
    BaseResponse accountFastregister(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 微信认证名称检测
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxverify/checkwxverifynickname", method = RequestMethod.POST)
    BaseResponse wxverifyCheckwxverifynickname(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取账号可以设置的所有类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getallcategories", method = RequestMethod.GET)
    BaseResponse wxopenGetallcategories(@RequestParam("access_token") String accessToken);

    /**
     * 添加类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/addcategory", method = RequestMethod.POST)
    BaseResponse wxopenAddcategory(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 删除类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/deletecategory", method = RequestMethod.POST)
    BaseResponse wxopenDeletecategory(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取账号已经设置的所有类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getcategory", method = RequestMethod.POST)
    BaseResponse wxopenGetcategory(@RequestParam("access_token") String accessToken);

    /**
     * 修改类目
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/modifycategory", method = RequestMethod.POST)
    BaseResponse wxopenModifycategory(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 查询当前设置的最低基础库版本及各版本用户占比（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/getweappsupportversion", method = RequestMethod.GET)
    BaseResponse wxopenGetweappsupportversion(@RequestParam("access_token") String accessToken);

    /**
     * 获取公众号关联的小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxamplinkget", method = RequestMethod.GET)
    BaseResponse wxopenWxamplinkget(@RequestParam("access_token") String accessToken);

    /**
     * 关联小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxamplink", method = RequestMethod.GET)
    BaseResponse wxopenWxamplink(@RequestParam("access_token") String accessToken);


    /**
     * 关联小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/wxampunlink", method = RequestMethod.GET)
    BaseResponse wxopenWxampunlink(@RequestParam("access_token") String accessToken);

    /**
     * 设置最低基础库版本（仅供第三方代小程序调用）
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/setweappsupportversion", method = RequestMethod.GET)
    BaseResponse wxopenSetweappsupportversion(@RequestParam("access_token") String accessToken);

    /**
     * 增加或修改二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpadd", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpadd(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 增加或修改二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpget", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpget(@RequestParam("access_token") String accessToken);

    /**
     * 获取校验文件名称及内容
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpdownload", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpdownload(@RequestParam("access_token") String accessToken);

    /**
     * 删除已设置的二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumpdelete", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumpdelete(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 发布已设置的二维码规则
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/qrcodejumppublish", method = RequestMethod.POST)
    BaseResponse wxopenQrcodejumppublish(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 模板消息-获取小程序模板库标题列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/list", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyList(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 模板消息-获取模板库某个模板标题下关键词库
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/get", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyGet(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 模板消息-组合模板并添加至帐号下的个人模板库
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/library/add", method = RequestMethod.POST)
    BaseResponse wxopenTemplateLibararyAdd(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 模板消息-获取帐号下已存在的模板列表
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/list", method = RequestMethod.POST)
    BaseResponse wxopenTemplateList(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 模板消息-删除帐号下的某个模板
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "wxopen/template/del", method = RequestMethod.POST)
    BaseResponse wxopenTemplateDel(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 创建 开放平台帐号并绑定公众号/小程序
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/create", method = RequestMethod.POST)
    BaseResponse openCreate(@RequestParam("access_token") String accessToken, @RequestBody Map map);


    /**
     * 将 公众号/小程序绑定到开放平台帐号下
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/bind", method = RequestMethod.POST)
    BaseResponse openBind(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 将公众号/小程序从开放平台帐号下解绑
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/unbind", method = RequestMethod.POST)
    BaseResponse openUnbind(@RequestParam("access_token") String accessToken, @RequestBody Map map);

    /**
     * 获取公众号/小程序所绑定的开放平台帐号
     *
     * @param accessToken
     * @return
     */
    @RequestMapping(value = "open/get", method = RequestMethod.POST)
    BaseResponse openGet(@RequestParam("access_token") String accessToken, @RequestBody Map map);

}
