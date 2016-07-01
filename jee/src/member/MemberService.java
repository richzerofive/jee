/**
 * 
 */
package member;

/**
 *@date   : 2016. 6. 17.
 *@author : 박승주
 *@file   : StudentService.java
 *@story  : 
*/
public interface MemberService {
	public String regist(MemberBean mem);
	public String show();
	public void update(String pw);
	public void delete();
}
/*String sql = "";
String sqlCreate ="create table member("
+"id varchar2(20) primary key,"
+"pw varchar2(20),"
+"name varchar2(20),"
+"reg_date varchar2(20),"
+"ssn varchar2(10))";*/