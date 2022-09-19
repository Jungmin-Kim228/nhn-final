객실 예약 API

- POST v1/hotel-api/hotels/{hotel-id}/rooms/{room-id}

1. 설계 이유
- RESTful한 api 설계를 따라 작성하였으며, userId 같은 경우에는 민감 정보에 해당할 수 있으므로 PathVariable 로 받지 않았음
- 따로 토큰화를 하거나, 인코딩 처리를 할 수 있음

2. 예약할 수 없는 사람이 호출하면 어떻게 응답?
- 예외 처리를 통해서 접근이 불가하다는 메시지를 남김
- 위와 같은 처리를 위해 UserIdNotValidException 예외를 발생시키도록 하였음
- 예약할 수 없는 사람이라도 무엇 때문에 서비스가 되지 않는지 메시지는 알 수 있도록 하는 것이 UX를 고려한 설계라고 판단하였음
