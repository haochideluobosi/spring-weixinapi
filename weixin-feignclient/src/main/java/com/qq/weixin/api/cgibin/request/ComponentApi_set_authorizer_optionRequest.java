package com.qq.weixin.api.cgibin.request;

import lombok.Data;

/**
 * @author gong.hua
 */
@Data
public class ComponentApi_set_authorizer_optionRequest {
    private String component_appid;
    private String authorizer_appid;
    private String option_name;
    private String option_value;
}
