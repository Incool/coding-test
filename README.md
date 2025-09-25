# coding-test
## 需求一 <br/>
Stage 1: For a given string that only contains alphabet characters a-z, if 3 or more consecutive characters are identical, remove them from the string. Repeat this process until there is no more than 3 identical characters sitting besides each other. <br/>
Example:   <br/>
Input: aabcccbbad  <br/>
Output:  <br/>
-> aabbbad  <br/>
-> aaad  <br/>
-> d <br/>

Stage 2: Instead of removing the consecutively identical characters, replace them with a single character that comes before it alphabetically <br/>
Example:  <br/>
ccc -> b  <br/>
bbb -> a  <br/>

Input: abcccbad  <br/>
Output:  <br/>
-> abbbad, ccc is replaced by b  <br/>
-> aaad, bbb is replaced by a  <br/>
-> d <br/>

## 需求二 
-Apply TDD way in coding <br/>
### Part1：
Write a program which supports 2 functions. <br/>
First function -init <br/>
A initialize API which take a list of data. <br/>
Second api - contains.str -> bool <br/>
a function which take a string as parameter and return either true or false. <br/>
it should check whether the provided string is one of the item provided in init <br/>
Sample function <br/>
init ["cat", "dog", "bird", "blur"] -> void / object <br/>
contains "cat"-> true  <br/>
contains "human"->false
### Part2：
We need to allow user input wildcard in contains api. <br/>
The symbol is * and can only match any 1 character only <br/>
Sample input / output <br/>
init ["cat", "dog", "bird", "blur"] -> void / object <br/>
 contains."*at"-> true  <br/>
 contains."b*t"->false  <br/>

# 版本
JDK 21 <br/>
Spring Boot 3.5.4 <br/>
Junit 5.10.2 <br/>
Mockito 5.11.0 <br/>
Jacoco 0.8.12 <br/>

# 启动代码可直接调用接口：
http://localhost:8080/api/v1/processor/deleteHandle?input=aabcccbbad <br/>
http://localhost:8080/api/v1/processor/replaceHandle?input=abcccbad

# 查看代码覆盖率
使用Jacoo 查看单元测试覆盖率 <br/>
终端执行： <br/>
``` shell
    mvn clean verify
```
查看单元测试覆盖率路径：~\code-test\HandleString\target\site\jacoco\index.html
<img width="1134" height="219" alt="40c3cb6e-86f2-4c03-8edf-89c09d6b8e0c" src="https://github.com/user-attachments/assets/2f67c865-5272-4445-a171-196cdafbb513" />

# 下面的没写单元测试
## 添加 Spring event
详情请看 com.handlestring.service.event 目录下

## 添加 静态代理以及动态代理（JDK、CGLib）
详情请看 com.handlestring.service.proxy 目录下