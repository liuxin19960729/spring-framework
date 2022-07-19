## 声明一个元素
```

<!ELEMENT name 元素类型>
//or 
<!ELEMENT name (元素类容)>


空元素
<!ELEMENT 元素名称 EMPTY>
  <xxx/>  非<xxxx>....<xxxx/>

PCDATA 文本信息
<!ELEMENT 元素名称 (#PCDATA)>
0 个或者多个文本
<!ELEMENT 元素名称 (#PCDATA)*>


任何内容元素
<!ELEMENT 元素名称 ANY>

带有子元素的元素
<!ELEMENT 元素名称 (子元素名称 1,子元素名称 2,.....)>


子元素只能出现一次
<!ELEMENT 元素名称 (子元素名称)> 

子元素至少出现一次
<!ELEMENT note (子元素名称+)>

子元素出现任意次数(0 or one)
<!ELEMENT 元素名称 (子元素名称)?>

子元素出现任意次数(0 or one or more)
<!ELEMENT 元素名称 (子元素名称)*>


message|body 或node 必须出现一个
<!ELEMENT note (to,from,header,(message|body))*> 上面的类型出现一次或者任意多的次数

混合模式
<!ELEMENT chapter (intro,(heading,(para|image|table|note))+)>

文本元素合法
<!ELEMENT name #PCDATA> 只包含文本

<!ELEMENT name (#PCDATA|e1|e2)*> 包含任意顺序文本和标签

除此之外其他类型都是非法
 例 <!ELEMENT name (#PCDATA,e1)> 



```

## 属性
```
<!ATTLIST 元素名称 属性名称 属性类型 默认值>
例：
 <!ATTLIST payment type CDATA "check">


属性类型

CDATA  character data
(en1|en2|...) 枚举列表值

ID 唯一值

IDREF 引用另一个元素ID

IDREFS 引用其他元素的列表值

NMTOKEN name xml token 合法的xml名称
NMTOKENS 合法的xml名称列表(以空白符隔开名字的标记列表)

ENTITY 实体 映入一个未解析的外部实体
ENTITIES 实体列表


#REQUIRED 属性值那必须的
#IMPLIED 属性值不是必须的
#FIXED value 属性值是固定的


<!ATTLIST contact fax CDATA #IMPLIED>
#IMPLIED 不是必须的
下面都是合法的
<contact fax="xx"> </contact>
<contact> </contact>


<!ATTLIST 元素名称 属性名称 (en1|en2|..) 默认值>
例
<!ATTLIST payment type (check|cash) "cash">

<payment type="check" />  or  <payment type="cash" /> 都是合法的

```

## 实体
```
作用:普通文本或特殊字符快捷方式变量


<!ENTITY 实体名称 "实体的值">

<!ENTITY writer "Bill Gates">
<!ENTITY copyright "Copyright W3School.com.cn">

<author>&writer;&copyright;</author>



外部声明实体
<!ENTITY 实体名称 SYSTEM "URI/URL">

<!ENTITY writer SYSTEM "http://www.w3school.com.cn/dtd/entities.dtd">
<!ENTITY copyright SYSTEM "http://www.w3school.com.cn/dtd/entities.dtd">


&writer 使用实体变量
```
## dtd 的引用
```
内部引入
<?xml version="1.0"?>
<!DOCTYPE configuration[
    <!ELEMENT beans xxxx,xxxx>
]>

<beans>
  
</beans>


外部引入
<?xml version="1.0"?>
<!DOCTYPE configuration SYSTEM "http://www.w3school.com.cn/dtd/note.dtd">

```

```
解析器回删除开始和结尾的空白符


```