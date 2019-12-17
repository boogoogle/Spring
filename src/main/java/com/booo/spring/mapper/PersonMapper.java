package com.booo.spring.mapper;

import com.booo.spring.bean.Person;

// @Mapper 或者 @MapperScan扫描装备的容器中
public interface PersonMapper {

    public Person getPersonById(Integer id);
    public Integer insertPerson(Person person); // 这里接口的返回值类型需要和Mysql的语句一致,不然会报错
}
