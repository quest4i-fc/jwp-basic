#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
* 설정한 wepapp 디렉터리 절대 경로가 앱의 / 경로가 됨.
* ServletContextListener의 구현 클래스인 ContextLoaderListener에서 데이터베이스 초기화 작업을 진행함.
* 웹 루트 경로를 서비스하는 유일한 HttpServlet을 상속한 DispatcherServlet의 인스턴가 load-on-startp값으로 인해 바로 만들어지면서 URL 정보를 담고 있는 RequestMapping 인스턴스 생성함.

#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
* 브라우저에서 Get 요청
* 루트 서비스 담당하는 DispatcherService의 service() 메소드 호출
* 루트 경로를 담당하는 HomeController 인스턴스를 생성.
* 컨트롤러가 ModelAndView 인스턴스를 index.jsp View와 questions Model 값으로 생성
* 마지막으로 view의 render 메서드를 사용해서 model을 보여주는 response를 브라우저로 전달한다.

#### 7. next.controller.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
* Question과 Answer의 추가, 삭제 작업에서 동시 작업을 방지하는 잠금 설정이 되어 있지 않아서, 수정되거나 삭제된 내용을 보여줄 수 있다.

