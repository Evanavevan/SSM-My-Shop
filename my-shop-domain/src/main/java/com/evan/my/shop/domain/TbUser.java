package com.evan.my.shop.domain;

import com.evan.my.shop.commons.persistence.BaseEntity;
import com.evan.my.shop.commons.utils.RegexUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {
    @Length(min = 6, max = 20, message = "姓名的长度必须介于 6 - 20 位之间")
    private String username;

    @JsonIgnore
    private String password;

    @Pattern(regexp = RegexUtils.PHONE, message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = RegexUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
}
