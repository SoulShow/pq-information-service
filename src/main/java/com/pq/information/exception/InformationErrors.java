package com.pq.information.exception;


import com.pq.common.exception.CommonErrors;
import com.pq.common.exception.ErrorCode;

/**
 * @author liutao
 */
public class InformationErrors extends CommonErrors {

    public final static ErrorCode USER_ID_IS_NULL = new InformationErrorCode("0001", "用户ID不能为空");
    public final static ErrorCode USER_NOT_FOUND = new InformationErrorCode("0002", "用户不存在");
    public final static ErrorCode USER_RESET_PASSWORD_TOKEN_EXPIRE = new InformationErrorCode("0003", "token失效或不存在");
    public final static ErrorCode COOKIE_NOT_VALID = new InformationErrorCode("0004", "Cookie验证失败");
    public final static ErrorCode AUTH_SECRET_KEY_NOT_FOUND = new InformationErrorCode("0005", "授权密钥未设置");
    public final static ErrorCode LOGIN_PARAM_NOT_VALID = new InformationErrorCode("0006", "登录参数未验证");
    public final static ErrorCode LOGIN_FAILED = new InformationErrorCode("0007", "登录失败");
    public final static ErrorCode CLEAR_USERINFO_EROR = new InformationErrorCode("0008", "清除缓存信息失败");
    public final static ErrorCode USER_IS_LOCKED = new InformationErrorCode("0009", "用户账号已经被冻结");
    public final static ErrorCode USER_UPDATE_FAILED = new InformationErrorCode("0010", "更新用户失败");
    public final static ErrorCode USER_VERIFY_PASSWORD_ERROR = new InformationErrorCode("0011", "用户校验密码错误");
    public final static ErrorCode USER_PHONE_IS_EXITS = new InformationErrorCode("0012", "抱歉,该手机号码已经注册过");
    public final static ErrorCode USER_LOGIN_PASSWORD_ERROR = new InformationErrorCode("0013", "手机号或登录密码有误");
    public final static ErrorCode USER_UPDATE_PASSWORD_SAME = new InformationErrorCode("0014", "新密码不能与原密码一致");
    public final static ErrorCode REGISTER_ERROR_MOBILE = new ErrorCode("0015", "请输入您正确的手机号");
    public final static ErrorCode REGISTER_ERROR = new ErrorCode("0016", "注册失败,请重新确认");
    public final static ErrorCode REGISTER_AGREE_USER_AGREEMENT_ERROR = new ErrorCode("0017", "请同意用户协议!");
    public final static ErrorCode USER_NEW_TOKEN_LOGIN_ERROR = new InformationErrorCode("0018", "您的账号已经在其他设备登录，\n" +
            "如非本人操作，请在重新登录后修改登录密码，\n" +
            "保障账户安全！");
    public final static ErrorCode USER_PASSWORD_MODIFY_NOT_SANME_ERROR = new ErrorCode("0019", "输入的两次密码不匹配");

    public final static ErrorCode CAPTCHA_REQUEST_TOO_MUCH = new InformationErrorCode("1000", "验证码请求发送次数过多");
    public final static ErrorCode CAPTCHA_ERROR_THAN_ACCEPTABLE= new InformationErrorCode("1001", "天内验证码输入错误次数超过限制");
    public final static ErrorCode CAPTCHA_TOO_CLOSE_WITH_LAST_TIME = new InformationErrorCode("1002", "距离上次发送验证码时间过短");
    public final static ErrorCode CAPTCHA_EXPIRED = new InformationErrorCode("1003", "验证码失效，请重新获取输入");
    public final static ErrorCode CAPTCHA_INPUT_ERROR = new InformationErrorCode("1004", "手机号或验证码有误");
    public final static ErrorCode CAPTCHA_CANNOT_DELIVERY = new InformationErrorCode("1005", "验证码发送失败，请稍后重试");

    public final static ErrorCode USER_NICKNAME_LENGTH_MORE_TEN = new InformationErrorCode("1006", "昵称不得超过10个字");
    public final static ErrorCode USER_NAME_LENGTH_MORE_TEN = new InformationErrorCode("1007", "姓名不得超过10个字");
    public final static ErrorCode USER_MAILID_IS_NOT_NULL = new InformationErrorCode("1008", "站内信id不能为空");
    public final static ErrorCode USER_NOT_REGISTER_LOGIN = new InformationErrorCode("1009", "用户未注册");
    public final static ErrorCode USER_MODIFY_INFO_IS_NULL = new InformationErrorCode("1010", "请填写修改信息");
    public final static ErrorCode USER_PHONE_IS_NOT_REGISTER_ERROR = new InformationErrorCode("1011", "手机号有误,请重新输入");

    public final static ErrorCode PAY_MINI_PROGRAM_NOT_EXIST_ERROR = new InformationErrorCode("1012", "微信小程序session获取失败");

    public final static ErrorCode USER_INFO_NOT_MATCH_ERROR = new InformationErrorCode("1012", "设置密码必须本人操作");
    public final static ErrorCode USER_PASSWORD_IS_EXIST_ERROR = new InformationErrorCode("1013", "用户已有密码,无法设置密码,请去忘记密码操作");



}
