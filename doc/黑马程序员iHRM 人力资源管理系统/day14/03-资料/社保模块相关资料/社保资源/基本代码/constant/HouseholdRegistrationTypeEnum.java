package com.ihrm.social.constant;

import org.apache.commons.lang.StringUtils;

public enum HouseholdRegistrationTypeEnum {

    LOCAL_TOWN(1, "本市城镇"), LOCAL_VILLAGE(2, "本市农村"), FOREIGNER_TOWN(3, "外埠城镇"), FOREIGNER_VILLAGE(4, "外埠农村");

    private final Integer key;
    private final String value;

    HouseholdRegistrationTypeEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public static HouseholdRegistrationTypeEnum getEnumByKey(Integer key) {
        if (null == key) {
            return null;
        }
        for (HouseholdRegistrationTypeEnum temp : HouseholdRegistrationTypeEnum.values()) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
        }
        return null;
    }

    public static HouseholdRegistrationTypeEnum getEnumByValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        for (HouseholdRegistrationTypeEnum temp : HouseholdRegistrationTypeEnum.values()) {
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
