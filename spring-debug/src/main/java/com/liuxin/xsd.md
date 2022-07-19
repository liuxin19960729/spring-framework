## XSD(Xml Schemal Definition)

### xsd 定义
```
<schema> 必须包含的一个跟元素
......

<schema>

真实定义

<xsd:schema xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsd="http://www.w3.org/2001/XMLSchema"
		targetNamespace="http://www.springframework.org/schema/beans">

</xsd:schema>


xmlns:xsd="http://www.w3.org/2001/XMLSchema"
schema 用到的元素和数据类型来自 http://www.w3.org/2001/XMLSchema 
规定 来自 http://www.w3.org/2001/XMLSchema 命名空间的元素和数据类型使用前缀 xsd

targetNamespace="http://www.springframework.org/schema/beans
显示被schema 定义的元素来自 http://www.springframework.org/schema/beans 命名空间


xmlns="http://www.springframework.org/schema/beans
默认的命名空间

```
### 元素
```
简易元素:简易元素指那些只包含文本的元素。它不会包含任何其他的元素或属性。

文本类型:
<xsd:element name="beans" type="">
type:
xsd:string
xsd:decimal
xsd:integer
xsd:boolean
xsd:date
xsd:time

**给建议元素设置默认值
<xsd:element name="color" type="xsd:string" default="red"/>

<color>xxx(or default red) <color/>

**设置元素默认值
<xsd:element name="color" type="xsd:string" fixed="red"/>
``` 

### xsd 属性
```
简易元素无法拥有符合类型的属性

<xsd:attribute name="元素名" type="">
xsd:string
xsd:decimal
xsd:integer
xsd:boolean
xsd:date
xsd:time

属性默认值
<xsd:attribute name="元素名" type="" default="" >

属性固定值
<xsd:attribute name="元素名" type="" fixed="" >

属性必须 or 可选(不写的情况下是可选的)

<xsd:attribute name="元素名" type="" use="required" >

```

### XSD 限定
```
*** 对数组限定
<xs:element name="age">

<xs:simpleType>
  <xs:restriction base="xs:integer">
    <xs:minInclusive value="0"/>
    <xs:maxInclusive value="120"/>
  </xs:restriction>
</xs:simpleType>

</xs:element


****枚举对一组值的限定
<xs:element name="car">

<xs:simpleType>
  <xs:restriction base="xs:string">
    <xs:enumeration value="Audi"/>
    <xs:enumeration value="Golf"/>
    <xs:enumeration value="BMW"/>
  </xs:restriction>
</xs:simpleType>

</xs:element> 


note: 当 <xsd:element name ="xx" type="ABC"> 的时候
<simpleType name="ABC"> 就是 元素 xx 的类型

**** 元素只接收[a-z] 中元素的一个
<xs:element name="letter">

<xs:simpleType>
  <xs:restriction base="xs:string">
    <xs:pattern value="[a-z]"/>
  </xs:restriction>
</xs:simpleType>

</xs:element> 


 [A-Z] 三个大写字母
 <xs:pattern value="[A-Z][A-Z][A-Z]"/>

三个任意字母
xs:pattern value="[a-zA-Z][a-zA-Z][a-zA-Z]"/>

xyz 中任意一个
<xs:pattern value="[xyz]"/>

5个【0-9】数子
<xs:pattern value="[0-9][0-9][0-9][0-9][0-9]"/>

a-z 任意多个
 <xs:pattern value="([a-z])*"/>

([a-z][A-Z]) 一对或多对
<xs:pattern value="([a-z][A-Z])+"/>

两个任意一个
<xs:pattern value="male|female"/>

8个字符字母 或数组 
<xs:pattern value="[a-zA-Z0-9]{8}"/>


不会移除 whiteSpace 空白符号
<xs:element name="address">

<xs:simpleType>
  <xs:restriction base="xs:string">
    <xs:whiteSpace value="preserve"//不会移除 whiteSpace 空白符号
  </xs:restriction>
</xs:simpleType>

</xs:element> 

//移除所有换行 空白 回车 空格 制表
<xs:whiteSpace value="replace"/>

开头结尾的空格移除  中间的换行 制表 空格 被替换为空给,连续的空格会缩减为一个
<xs:whiteSpace value="collapse"/>


限定字符长度
如需限制元素中值的长度，我们需要使用 length、maxLength 以及 minLength 限定。
 <xs:length value="8"/> 长度为8

 最小和最大
  <xs:minLength value="5"/>
   <xs:maxLength value="8"/>


enumeration	定义可接受值的一个列表
fractionDigits	定义所允许的最大的小数位数。必须大于等于0。
length	定义所允许的字符或者列表项目的精确数目。必须大于或等于0。
maxExclusive	定义数值的上限。所允许的值必须小于此值。
maxInclusive	定义数值的上限。所允许的值必须小于或等于此值。
maxLength	定义所允许的字符或者列表项目的最大数目。必须大于或等于0。
minExclusive	定义数值的下限。所允许的值必需大于此值。
minInclusive	定义数值的下限。所允许的值必需大于或等于此值。
minLength	定义所允许的字符或者列表项目的最小数目。必须大于或等于0。
pattern	定义可接受的字符的精确序列。
totalDigits	定义所允许的阿拉伯数字的精确位数。必须大于0。
whiteSpace	定义空白字符（换行、回车、空格以及制表符）的处理方式。

```

## XSD(Xml Schemal Definition) 的复合类型
```
例子
空元素
   <product pid="1345"/>
包含其他元素
   <employee>
   <firstname>John</firstname>
   <lastname>Smith</lastname>
   </employee>

简易元素
<food type="dessert">Ice cream</food>


文本+元素
<description>
It happened on <date lang="norwegian">03.03.99</date> ....
</description

```

### 定义复合元素
```
方式一
<xs:element name="employee">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>

方式二
<xs:element name="employee" type="personinfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
  </xs:sequence>
</xs:complexType>


  方式二好处 
多个元素可以指定同一个符合类型
<xs:element name="employee" type="personinfo"/>
<xs:element name="student" type="personinfo"/>
<xs:element name="member" type="personinfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
  </xs:sequence>
</xs:complexType>


在复合类型上扩展元素

<xs:element name="employee" type="fullpersoninfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
  </xs:sequence>
</xs:complexType>

<xs:complexType name="fullpersoninfo">
  <xs:complexContent>
    <xs:extension base="personinfo">
      <xs:sequence>
        <xs:element name="address" type="xs:string"/>
        <xs:element name="city" type="xs:string"/>
        <xs:element name="country" type="xs:string"/>
      </xs:sequence>
    </xs:extension>
  </xs:complexContent>
</xs:complexType>

```
### XSD 空元素
```

<xs:element name="product">
  <xs:complexType>
    <xs:attribute name="prodid" type="xs:positiveInteger"/>// proid属性必须为 正数
  </xs:complexType>
</xs:element>
```
### XSD 仅含元素

```
<person>
<firstname>John</firstname>
<lastname>Smith</lastname>
</person>

<xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>
```

### 仅含文本
```
在复合类型里面使用建议类型的文本
<xs:element name="shoesize">
  <xs:complexType>
    <xs:simpleContent>
      <xs:extension base="xs:integer"> //只能使用数字
        <xs:attribute name="country" type="xs:string" />
      </xs:extension>
    </xs:simpleContent>
  </xs:complexType>
</xs:element>


or

<xs:element name="shoesize">
  <xs:complexType>
    <xs:simpleContent>
      <xs:restriction base="xs:integer"> //只能使用数字
        <xs:attribute name="country" type="xs:string" />
      </xs:restriction>
    </xs:simpleContent>
  </xs:complexType>
</xs:element>

```

### 混合内容
```
<xs:element name="letter">
  <xs:complexType mixed="true">
    <xs:sequence>
      <xs:element name="name" type="xs:string"/>
      <xs:element name="orderid" type="xs:positiveInteger"/>
      <xs:element name="shipdate" type="xs:date"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>

mixed=true
字符可以出现在子元素之间

```

## 指示器
```
All(任意顺序出现) 每个子元素必须出现一次(dtd:<!ELEMENT note (子元素名称+)>) 
<xs:element name="person">
  <xs:complexType>
    <xs:all>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:all>
  </xs:complexType>
</xs:element>



Choice 出现多个子元素的任意一个<!ELEMENT note message|body)
<xs:element name="person">
  <xs:complexType>
    <xs:choice>
      <xs:element name="employee" type="employee"/>
      <xs:element name="member" type="member"/>
    </xs:choice>
  </xs:complexType>
</xs:element>


Sequence 按顺序出现 (<!ELEMENT 元素名称 (子元素名称 1,子元素名称 2,.....)>)
<xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>


出现的元素出现的频率
maxOccurs  最多出现的评率
<xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="full_name" type="xs:string"/>
      <xs:element name="child_name" type="xs:string" maxOccurs="10"/>// minOccurs 最少为1次
    </xs:sequence>
  </xs:complexType>
</xs:element>

minOccurs
<xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="full_name" type="xs:string"/>
      <xs:element name="child_name" type="xs:string"
      maxOccurs="10" minOccurs="0"/> 
    </xs:sequence>
  </xs:complexType>
</xs:element>




元素组
Group name
Group 指示器用于定义相关的数批元素。
<xs:group name="组名称">
  ...
</xs:group>

<xs:group name="persongroup">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
    <xs:element name="birthday" type="xs:date"/>
  </xs:sequence>
</xs:group>


<xs:group name="persongroup">
  <xs:sequence>
    <xs:element name="firstname" type="xs:string"/>
    <xs:element name="lastname" type="xs:string"/>
    <xs:element name="birthday" type="xs:date"/>
  </xs:sequence>
</xs:group>

<xs:element name="person" type="personinfo"/>

<xs:complexType name="personinfo">
  <xs:sequence>
    <xs:group ref="persongroup"/>
    <xs:element name="country" type="xs:string"/>
  </xs:sequence>
</xs:complexType


属性组
attributeGroup name


<xs:attributeGroup name="personattrgroup">
  <xs:attribute name="firstname" type="xs:string"/>
  <xs:attribute name="lastname" type="xs:string"/>
  <xs:attribute name="birthday" type="xs:date"/>
</xs:attributeGroup>

<xs:element name="person">
  <xs:complexType>
    <xs:attributeGroup ref="personattrgroup"/>
  </xs:complexType>
</xs:element>

```
### any 
```
任意内容元素
dtd:<!ELEMENT 元素名称 ANY>

xs:element name="person">
  <xs:complexType>
    <xs:sequence>
      <xs:element name="firstname" type="xs:string"/>
      <xs:element name="lastname" type="xs:string"/>
      <xs:any minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>
</xs:element>

在lastname元素之后允许任意的扩展



```

## xsd 的引用
```
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


```
