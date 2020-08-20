package naver.dkxkgh98.smartorder.domain;

import lombok.Data;

@Data
public class StoreMenu {
    private String menuCode;   // 메뉴코드
    private String menuName ;    // 메뉴명
    private String menuInfo ;   // 메뉴설명
    private Integer menuPrice;    // 메뉴가격
    private String menuPhoto;   // 메뉴사진
    private String menuSection; // 메뉴구분
    private String storeNickname; // 가게닉네임
}
    