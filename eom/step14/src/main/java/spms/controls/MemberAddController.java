package spms.controls;

import java.util.Map;

import spms.dao.MySqlMemberDao;
import spms.vo.Member;

// ���� ��ü ������ ���� �ν��Ͻ� ������ ���� �޼��� �߰�
//- ���� ���� ��ü�� ������ ���� �ڵ� ����
public class MemberAddController implements Controller {
  MySqlMemberDao memberDao;
  
  public MemberAddController setMemberDao(MySqlMemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    if (model.get("member") == null) { // �Է����� ��û�� ��
      return "/member/MemberForm.jsp";
      
    } else { // ȸ�� ����� ��û�� ��
      Member member = (Member)model.get("member");
      memberDao.insert(member);
      
      return "redirect:list.do";
    }
  }
}