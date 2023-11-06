package com.ict01.jpaproject02;

public class ResourceNotFoundException extends Exception{

  private static final long serialVersionUID = 1L;

  // 리소스를 찾을 수 없을 때 발생하는 예외를 생성하는 생성자
  public ResourceNotFoundException(Object resourceId) {
    // 주어진 resource ID를 문자열로 변환하여 예외 메시지로 설정한다.
    super(resourceId != null ? resourceId.toString() : null);
  }

}
