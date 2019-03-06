package org.spring.springcloud.weixinfeignclienttest;

import com.alibaba.fastjson.JSON;
import com.qq.weixin.api.cgibin.CgibinClient;
import com.qq.weixin.api.cgibin.request.*;
import com.qq.weixin.api.cgibin.response.ComponentApi_query_authResponse;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeixinFeignclientTestApplication.class)
public class CgibinClientTests {

    @Autowired
    private CgibinClient cgibinClient;

    private String token = "19_g62tFf2xqOG1gDR1MZZhguyMxtXNYp1iUe8hNq-lKT6pcvAFiPTp6oDYZunRaG2ke45pNiuxHv26b3OjkR62MF8hqELSL7TkRIcvZZb3MKJ4ygbuSUnxDaKdoMIZVAgAIASOT";
    private String componentToken = "19_Mepz8ZhKUchyY9cAlxLcwV-5XH6JQSrU5HsFj6fEpvKYPRFpXk35kQ_3O12shswlPBbqvpLBfkZGoZmYlcEumPKWym9WyDYK3vOptmQAlvuIdRu89eqbEqzz4psJFnLiuBTAM2znKs28JL4_GNZcAGACJV";


    private Object response;
    private Object req;

    @Before
    public void before() {


    }

    @After
    public void after() {
        System.out.println(JSON.toJSONString(req, true));
        System.err.println(JSON.toJSONString(response, true));
    }

    @Test
    public void accountComponentrebindadmin() {
    }

    @Test
    public void accountFastregister() {
    }

    @Test
    public void accountGetaccountbasicinfo() {
    }

    @Test
    public void accountModifyheadimage() {
    }

    @Test
    public void accountModifysignature() {
    }

    @Test
    public void clear_quota() {
    }

    @Test
    public void componentApi_authorizer_token() {
    }

    @Test
    public void componentApi_create_preauthcode() {
        val request = new ComponentApi_create_preauthcodeRequest();
        request.setComponent_appid("wxe3987587f06091cf");
        response = cgibinClient.componentApi_create_preauthcode(componentToken, request);
        req = request;
    }

    @Test
    public void componentApi_get_authorizer_info() {
        val request = new ComponentApi_get_authorizer_infoRequest();
        request.setAuthorizer_appid("wx01fa97816dcd707c");
        request.setComponent_appid("wxe3987587f06091cf");
        response = cgibinClient.componentApi_get_authorizer_info(componentToken, request);
        req = request;
    }

    @Test
    public void componentApi_get_authorizer_option() {
    }

    @Test
    public void componentApi_query_auth() {
        ComponentApi_query_authRequest componentApi_query_authRequest = new ComponentApi_query_authRequest();
        componentApi_query_authRequest.setComponent_appid("wxb5520b267480440f");
        componentApi_query_authRequest.setAuthorization_code("queryauthcode@@@Ih2aJaVvoZaCSpgaJkef-XFcwyAJ0zDWJri8t-Vft0pw-2XfCqcutzbO-crp7cjau2RTlH-Ia2-Mxrl8_CCVTw");
        response = cgibinClient.componentApi_query_auth(componentToken, componentApi_query_authRequest);
        req = componentApi_query_authRequest;

    }

    @Test
    public void componentApi_set_authorizer_option() {
    }

    @Test
    public void componentApiComponentToken() {
        val componentTokenRequest = new ComponentTokenRequest();
        componentTokenRequest.setComponent_appid("wxe3987587f06091cf");
        componentTokenRequest.setComponent_appsecret("10c1bde9468906b5a981302136cacf37");
        componentTokenRequest.setComponent_verify_ticket("ticket@@@nBM6F2ykguKB41H40NOFLlrljtJRFiV-5dD2iOyI7iGGTBVwR6phGduA8-C-TJL21ZmCZas1ii88doVVHfUKdg");
        cgibinClient.componentApiComponentToken(componentTokenRequest);
        req = componentTokenRequest;
    }

    @Test
    public void componentClear_quota() {
    }

    @Test
    public void componentFastregisterweappCreate() {
    }

    @Test
    public void componentFastregisterweappSearch() {
        response = cgibinClient.componentFastregisterweappSearch(componentToken,
                null);
    }

    @Test
    public void expressBusinessDeliveryGetall() {
    }

    @Test
    public void expressBusinessOrderAdd() {
    }

    @Test
    public void expressBusinessOrderCancel() {
    }

    @Test
    public void expressBusinessOrderGet() {
    }

    @Test
    public void expressBusinessPathGetall() {
    }

    @Test
    public void expressBusinessQuotaGet() {
    }

    @Test
    public void expressDeliveryContactGet() {
    }

    @Test
    public void expressDeliveryPathUpdate() {
    }

    @Test
    public void expressDeliveryserviceBusinessUpdate() {
    }

    @Test
    public void expressDeliveryTemplatePreview() {
    }

    @Test
    public void mediaGet() {
    }

    @Test
    public void mediaUpload() {
    }

    @Test
    public void menuAddconditional() {
    }

    @Test
    public void menuCreate() {
        val request = new MenuCreateRequest();
        MenuCreateRequest.ViewButton viewButton = new MenuCreateRequest.ViewButton();
        viewButton.setUrl("http://www.baidu.com");
        viewButton.setName("test");
        request.setButton(new MenuCreateRequest.Button[]{viewButton, viewButton, viewButton});
        System.err.println(JSON.toJSONString(request, true));
        response = cgibinClient.menuCreate(token, request);
    }

    @Test
    public void menuDelete() {
    }

    @Test
    public void menuGet() {
        response = cgibinClient.menuGet(token);
    }

    @Test
    public void messageCustomSend() {
    }

    @Test
    public void messageCustomTyping() {
    }

    @Test
    public void messageWxopenActivityidCreate() {
    }

    @Test
    public void messageWxopenTemplateSend() {
    }

    @Test
    public void messageWxopenTemplateUniform_send() {
    }

    @Test
    public void messageWxopenUpdatablesgSend() {
    }

    @Test
    public void openBind() {
    }

    @Test
    public void openCreate() {
    }

    @Test
    public void openGet() {
    }

    @Test
    public void openUnbind() {
    }

    @Test
    public void qrcodeCreate() {
        val qrcodeCreateRequest = new QrcodeCreateRequest();
        cgibinClient.qrcodeCreateTemp(token, 864000,123);
        req = qrcodeCreateRequest;
    }

    @Test
    public void templateApi_set_industry() {
    }

    @Test
    public void ticketGetticket() {
        response = cgibinClient.ticketGetticket(token);
    }

    @Test
    public void token() {
        response = cgibinClient.token("wxe57e8b54cbe75bd0", "22642be432f7849be45956de461333c8");

    }

    @Test
    public void wxaappCreatewxaqrcode() {
    }

    @Test
    public void wxopenAddcategory() {
    }

    @Test
    public void wxopenDeletecategory() {
    }

    @Test
    public void wxopenGetallcategories() {
    }

    @Test
    public void wxopenGetcategory() {
    }

    @Test
    public void wxopenGetweappsupportversion() {
    }

    @Test
    public void wxopenModifycategory() {
    }

    @Test
    public void wxopenQrcodejumpadd() {
    }

    @Test
    public void wxopenQrcodejumpdelete() {
    }

    @Test
    public void wxopenQrcodejumpdownload() {
    }

    @Test
    public void wxopenQrcodejumpget() {
    }

    @Test
    public void wxopenQrcodejumppublish() {
    }

    @Test
    public void wxopenSetweappsupportversion() {
    }

    @Test
    public void wxopenTemplateDel() {
    }

    @Test
    public void wxopenTemplateLibararyAdd() {
    }

    @Test
    public void wxopenTemplateLibararyGet() {
    }

    @Test
    public void wxopenTemplateLibararyList() {
    }

    @Test
    public void wxopenTemplateList() {
    }

    @Test
    public void wxopenWxamplink() {
    }

    @Test
    public void wxopenWxamplinkget() {
    }

    @Test
    public void wxopenWxampunlink() {
    }

    @Test
    public void wxverifyCheckwxverifynickname() {
    }


}

