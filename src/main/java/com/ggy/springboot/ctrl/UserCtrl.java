package com.ggy.springboot.ctrl;

import com.ggy.springboot.entity.User;
import com.ggy.springboot.jpa.UserJPA;
import com.ggy.springboot.utils.MD5;
import com.ggy.springboot.utils.SysCode;
import model.BaseResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/userCtrl")
public class UserCtrl {
    @Autowired
    private UserJPA userJPA;


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/signUp")
    public BaseResultModel signUp(User user) {
        BaseResultModel model = new BaseResultModel();
        MD5 md5 = new MD5();
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserType("1");
        if ("".equals(user.getPwd()) || user.getPwd() == null) {
            user.setPwd(md5.getMD5ofStr("123456"));
        } else {
            user.setPwd(md5.getMD5ofStr(user.getPwd()));
        }
        try {
            userJPA.save(user);
            model.setRtnMsg("成功注册用户：" + user.getUserName());
        } catch (Exception e) {
            model.setRtnCode(SysCode.RTN_CODE_FAIL);
            model.setRtnMsg("注册失败！");
        }
        return model;
    }

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public List<User> list() {
        return userJPA.findAll();
    }


    /**
     * 登陆
     *
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public BaseResultModel login(User user, HttpServletRequest request) {
        BaseResultModel model = new BaseResultModel();
        Optional<User> userEntity = userJPA.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getUserName()));
                return null;
            }
        });
        if (!userEntity.isPresent()) {
            model.setRtnCode(SysCode.RTN_CODE_FAIL);
            model.setRtnMsg("用户不存在，登陆失败");
        } else if (!userEntity.equals(user)) {
            model.setRtnMsg("用户密码不相符，登陆失败");
            model.setRtnCode(SysCode.RTN_CODE_FAIL);
        }
        if (model.getRtnCode() == 0) {
//            登陆成功，将用户写入session
            request.getSession().setAttribute("session_user", userEntity);
        }
        return model;
    }

}
