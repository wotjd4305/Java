//package com.test;
//
//import java.io.Serializable;
//import java.security.SecureRandom;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class ExcelMaker {
//    int length = 6;
//    boolean useLetters = true;
//    boolean useNumbers = true;
//
//    ArrayList<UserInfo> userInfos = new ArrayList<>();
//
//    private static final SecureRandom random = new SecureRandom();
//
//    public ArrayList<HashMap<String, String>> createDummyData(long dummySize) {
////        userInfos.add(new UserInfo("jy_store", "NG0000-LG0000-BB0000-BP0002-SS0000", "NG0000-LG0000-BB0000-BP0002", "정연지점", "정연상점"));
////        userInfos.add(new UserInfo("pjh_store01", "NG0001-BP0006-SS0000", "NG0001-BP0006", "정훈지점", "정훈지점_정훈상점0811"));
////        userInfos.add(new UserInfo("yoon_store02", "NG0001-BP0018-SS0000", "NG0001-BP0018", "여태지점", "여태상점"));
////        userInfos.add(new UserInfo("yoon_store03", "NG0001-BP0019-SS0000", "NG0001-BP0019", "여태지점_3", "여태상점_3"));
//        userInfos.add(new UserInfo("new3_st", "NG0003-BP0005-SS0000", "NG0003-BP0005", "new3지점", "new3 상점(꽁꽁꽁)롱롱길게"));
//
//        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
//        for(long i = 0L; i < dummySize; i++){
//            HashMap<String, String> hashMap = new HashMap<>();
//            hashMap.put("orderNo", createRandomString(length, useLetters, useNumbers));
//            hashMap.put("nowDate", new SimpleDateFormat("yyMMddHHmmss").format(new java.util.Date()));
//
//            UserInfo userInfo = userInfos.get(random.nextInt(userInfos.size()));
//            hashMap.put("userId", userInfo.getUserId());
//            hashMap.put("accountId", userInfo.getAccountId());
//            hashMap.put("branchId", userInfo.getBranchId());
//            hashMap.put("branchName", userInfo.getBranchName());
//            hashMap.put("storeName", userInfo.getStoreName());
//            arrayList.add(hashMap);
//        }
//
//        return arrayList;
//    }
//
//    public String createRandomString(int length, boolean useLetters, boolean useNumbers) {
//        return RandomStringUtils.random(length, useLetters, useNumbers);
//    }
//
//    public void test(){
//        System.out.println(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//        System.out.println(LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//    }
//}
//
//
//class UserInfo implements Serializable {
//    private String userId = null;
//    private String accountId = null;
//    private String branchId = null;
//    private String branchName = null;
//    private String storeName = null;
//
//    public String getUserId() { return userId; }
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//    public String getAccountId() { return accountId; }
//    public void setAccountId(String accountId) {
//        this.accountId = accountId;
//    }
//    public String getBranchId() { return branchId; }
//    public void setBranchId(String branchId) {
//        this.branchId = branchId;
//    }
//    public String getBranchName() { return branchName; }
//    public void setBranchName(String branchName) {
//        this.branchName = branchName;
//    }
//    public String getStoreName() { return storeName; }
//    public void setStoreName(String storeName) {
//        this.storeName = storeName;
//    }
//
//    public UserInfo (String userId, String accountId, String branchId, String branchName, String storeName) {
//        this.userId = userId;
//        this.accountId = accountId;
//        this.branchId = branchId;
//        this.branchName = branchName;
//        this.storeName = storeName;
//    }
//
//    public UserInfo (String userId, String accountId, String branchId, String branchName) {
//        this.userId = userId;
//        this.accountId = accountId;
//        this.branchId = branchId;
//        this.branchName = branchName;
//    }
//
//    public static UserInfoBuilder builder(){
//        return new UserInfoBuilder();
//    }
//}
//
//class UserInfoBuilder{
//    private String userId;
//    private String accountId;
//    private String branchId;
//    private String branchName;
//    private String storeName;
//
//    public UserInfoBuilder userId(String userId) { this.userId = userId; return this;}
//    public UserInfoBuilder accountId(String accountId) { this.accountId = accountId; return this;}
//    public UserInfoBuilder branchId(String branchId) { this.branchId = branchId; return this;}
//    public UserInfoBuilder branchName(String branchName) { this.branchName = branchName; return this;}
//    public UserInfoBuilder storeName(String storeName) { this.storeName = storeName; return this;}
//
////    public  UserInfo build(){
////        UserInfo userInfo = new UserInfo();
////        userInfo.setUserId(userId);
////        userInfo.setAccountId(accountId);
////        userInfo.setBranchId(branchId);
////        userInfo.setBranchName(branchName);
////        userInfo.setStoreName(storeName);
////        return userInfo;
////    }
//}
