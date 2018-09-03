package com.kz.kzsys.model;


import com.kz.kzsys.core.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@ToString
public class KzUser extends BaseModel{
    @Getter @Setter private int uid;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private int telephone;
    @Getter @Setter private String sex;


}
