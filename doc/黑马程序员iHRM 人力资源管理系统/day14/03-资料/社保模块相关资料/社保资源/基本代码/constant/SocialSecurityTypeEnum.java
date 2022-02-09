package com.ihrm.social.constant;

import org.apache.commons.lang.StringUtils;

public enum SocialSecurityTypeEnum {

    FIRST(1, "首次开户"), NOT_FIRST(2, "非首次开户");

    private final Integer key;
    private final String value;

    SocialSecurityTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static SocialSecurityTypeEnum getEnumByKey(Integer key) {
        if (null == key) {
            return null;
        }
        for (SocialSecurityTypeEnum temp : SocialSecurityTypeEnum.values()) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
        }
        return null;
    }

    public static SocialSecurityTypeEnum getEnumByValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        for (SocialSecurityTypeEnum temp : SocialSecurityTypeEnum.values()) {
            if (temp.getValue().equals(value)) {
                return temp;
            }
        }
        return null;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
