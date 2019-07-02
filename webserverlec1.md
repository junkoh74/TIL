## [ 웹 서버 실습 2 ]

```java
("<br><a href='" + request.getHeader("referer") + "'>상품 선택화면</a> "); // request.getHeader는 이 페이지로 넘어온 주소를 가져옴
("<a href='" + request.getRequestURI() + ">" + "상품비우기" + "</a>"); // request.getRequestURI()는 현재 페이지의 URI를 가져옴
```

Cookie 기술 : 클라이언트에 정보를 저장 // 보안에 취약

HttpSession 기술 : 여러 클라이언트를 웹서버에 저장 // 클라이언트 별로 한개씩 요청하며 정해진 시간동안 접속이 없다							   면 삭제가 가능하며 내부적으로 cookie를 사용, 최대 유지 시간은 브라우저가 살아 있는 동안
							    기간에 따라 저장 구역이 나뉘어짐 : 장기간 == DataBase, 단기간 == Session



## [ 파일 업로드]

쿼리 문자열 : form 태그를 통해서 서버에 전달이 가능하도록 변환하여 전달하는 URL의 일부분을

클라이언트에서 서버에게 요청을 보낼 때 servlet과 같은 서버명으로 요청 시에는 (?name = value)로 구성된 쿼리 문자열을 전달하 수 있다/. (영문, 숫자, 일부 특수문자는 그대로 전달이 가능하며 나머지는 인코딩되어 전달 :: 
예 ) %문자%문자%)
==> name=value&name=value.....
	   application/x-www-form-urlencoded
 // name = value 로 전달하는 컨텐트 타입 방식

서버에게 전달하는 데이터 클라이언트에 존재하는 파일을 첨부하여 요청하려는 경우에는 다른 형식으로 전달해야 한다 
--> 파일은 name=value형식을 적용할 수 없다
--> multipart/form-data 포맷으로 :: 사용하기 위하여서는 반듯이 post방식이어야 한다

@MultipartConfig 여러개의 파티션으로 나누어서 진행
추출 하기위해서는 request.getParts();

```java
package core;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/part")
@MultipartConfig  
public class PartTestServlet extends HttpServlet {   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        Collection<Part> parts = request.getParts();
        System.out.println("========== 요청 받음 =========");
        for(Part part : parts) {        	
            System.out.print("name : ");
            System.out.println(part.getName()); // 겟네임 추출
            System.out.println("[ 헤더 정보 ] ");
            for(String headerName : part.getHeaderNames()) {
                System.out.print(headerName + " : "); // 
                System.out.println(part.getHeader(headerName));
            }
            System.out.println("size : "+ part.getSize());
            String filename = part.getSubmittedFileName(); // 실제 클라이언트가 첨부한 파일 이름 추출
            if (filename != null)
            	System.out.println("file name : "+filename);
            System.out.println("------------------------------------");
        }        
    }
}
```

```java
package core;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/upload")
@MultipartConfig (location = "c:/uploadtest") // 여러 파트들에 대한 처리를 용이 하게 해주는 방식
public class UploadServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		request.setCharacterEncoding("utf-8");
		String path = "c:/uploadtest";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdirs();
		}
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getContentType() != null) { // 업로드 되는 파일이 어떤 타입인가 & 업로드 되는 파일이 있는지
				String fileName = part.getSubmittedFileName(); // 있다면 파일 이름 추출
				if (fileName != null) { // 파일 이름이 있을 경우
					part.write(fileName.substring(0, fileName.lastIndexOf(".")) + // 파일 이름 첫번째 부터 . 전까지 + _ + 타임스탬프 + . 이후 파일 이름 (확장자명)
							"_"	+ System.currentTimeMillis() 
							+ fileName.substring(fileName.lastIndexOf(".")));
					out.print("<br>업로드한 파일 이름: " + fileName); // 파일 이름 출력
					out.print("<br>크기: " + part.getSize()); // 파일 크기 출력
				}
			} else { // 업로드 되는 파일의 컨텐트 타입이 null
				String partName = part.getName();
				String fieldValue = request.getParameter(partName);
				out.print("<br>" + partName + ": " + fieldValue);			
			}
		}
		out.close();		
	}
}
```

### [ 지시자 태그 ]

**페이지 지시자**

```jsp
<%@ page
[ language="java" // 자바 언어만 사용 가능
[ extends="package.class" ] // 각 WAS의 부모 클래스가 정해져 있기 때문에 선언 하는 무의미
[ import="{package.class | package.*}, ..." ]
[ session="true|false" ]
[ buffer="none|8kb|sizekb" ]
[
autoFlush="true|false" ]
[ errorPage="relativeURL" ]
[ contentType="mimeType [ ; charset=characterSet ]" |
"text/html ; charset=ISO 8859 1" ]
[ isErrorPage="true|false" ]
[ pageEncoding="characterSet | ISO8859 1" ]
[ isELIgnored="true|false"]
%>
```

**Include 지시자**

소스 코드가 포함되는 부분에 붙여 넣기 위해서 include지시자를 사용
확장자로는 특별이 정해져 있지 않지만 jspf (jsp fragment) 라는 의미로 사용을 많이함

```jsp

```

