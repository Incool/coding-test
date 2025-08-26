# coding-test
代码测试 <br/>
Stap 1: For a given string that only contains alphabet characters a-z, if 3 or more consecutive characters are identical, remove them from the string. Repeat this process until there is no more than 3 identical characters sitting besides each other. <br/>
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
使用Jacoo 查看单元测试覆盖率
终端执行：mvn clean verify
<img width="1134" height="219" alt="40c3cb6e-86f2-4c03-8edf-89c09d6b8e0c" src="https://github.com/user-attachments/assets/2f67c865-5272-4445-a171-196cdafbb513" />
