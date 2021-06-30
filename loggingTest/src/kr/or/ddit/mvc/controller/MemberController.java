package kr.or.ddit.mvc.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 6. 전체 자료 Excel로 출력 7. 전체 자료 PDF로 출력
 * 
 * @author PC-05
 *
 */
public class MemberController {
	private Scanner scan;
	private IMemberService service;
	private String filePath;
	private XSSFWorkbook workbook;
	private FileOutputStream fos;
	private Document document;

	public MemberController() {
		scan = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
		workbook = new XSSFWorkbook();
		document = new Document(PageSize.A4, 20, 20, 30, 30);

	}

	public static void main(String[] args) {
		new MemberController().start();
	}

	private int mainPage() {
		System.out.println("---작업 선택 ---");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("6. 전체 자료 Excel로 출력");
		System.out.println("7. 전체 자료 PDF로 출력");
		System.out.println("0. 작업 끝");
		System.out.println("------------");
		System.out.print("작업 선택 > ");
		return scan.nextInt();
	}

	private void start() {
		while (true) {
			int inputNum = mainPage();
			switch (inputNum) {
			case 1:
				insertData();
				break;
			case 2:
				deleteData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				getAllMemberList();
				break;
			case 5:
				updateData2();
				break;
			case 6:
				outputExcel();
				break;
			case 7:
				outputPDF();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				scan.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

	private void outputPDF() {
		try {
			PdfWriter.getInstance(document, new FileOutputStream("d:/d_other/MemberList.pdf"));
			document.open();
			String fontName = "C:\\Users\\PC-05\\Desktop\\Developer file\\font\\NanumFontSetup_TTF_BARUNGOTHIC\\NanumBarunGothic.ttf";
			BaseFont bfont = BaseFont.createFont(fontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(bfont);
			
			List<MemberVO> list = service.getAllMemberList();
			PdfPTable table = new PdfPTable(5);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.setTotalWidth(1000f);

			PdfPCell cell = null;
			String[] head = { "ID", "PASSWORD", "NAME", "TEL", "ADDR" };
			for (int i = 0; i < head.length; i++) {
				
				cell = new PdfPCell(new Paragraph(head[i]));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(40);
				table.addCell(cell);
			}
			for (int i = 0; i < list.size(); i++) {
				MemberVO vo = list.get(i);
				String[] content = { vo.getMemId(), vo.getMemPass(), vo.getMemName(), vo.getMemTel(), vo.getMemAddr() };
				for (int j = 0; j < content.length; j++) {
					String voContent = content[j];
					Paragraph paragraph;
					if(content[j].equals(vo.getMemName()) || content[j].equals(vo.getMemAddr())) {
						paragraph = new Paragraph(voContent, font);
					}else {
						paragraph = new Paragraph(voContent);
					}
					
					
					cell = new PdfPCell(paragraph);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setFixedHeight(40);
					table.addCell(cell);
				}
			}

			document.add(table);
			document.add(new Paragraph(" "));

			System.out.println("PDF파일이 출력되었습니다.");

			document.close();
		} catch (Exception e) {
			System.out.println("PDF파일의 출력에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	private void outputExcel() {
		List<MemberVO> voList = service.getAllMemberList();
		XSSFSheet sheet = workbook.createSheet("MeberList");
		XSSFRow row = null;
		XSSFCell cell = null;

		row = sheet.createRow(0);
		for (int i = 0; i < 5; i++) {
			cell = row.createCell(i);
			String value = "";
			switch (i) {
			case 0:
				value = "ID";
				break;
			case 1:
				value = "패스워드";
				break;
			case 2:
				value = "이름";
				break;
			case 3:
				value = "전화번호";
				break;
			case 4:
				value = "주소";
				break;
			}
			cell.setCellValue(value);
		}
		for (int i = 1; i < voList.size() + 1; i++) {
			row = sheet.createRow(i);
			MemberVO vo = voList.get(i - 1);
			for (int j = 0; j < 5; j++) {
				cell = row.createCell(j);
				switch (j) {
				case 0:
					cell.setCellValue(vo.getMemId());
					break;
				case 1:
					cell.setCellValue(vo.getMemPass());
					break;
				case 2:
					cell.setCellValue(vo.getMemName());
					break;
				case 3:
					cell.setCellValue(vo.getMemTel());
					break;
				case 4:
					cell.setCellValue(vo.getMemAddr());
					break;
				}

			}
		}
		filePath = "d:/d_other/MemberList.xlsx";
		try {
			fos = new FileOutputStream(filePath);
			workbook.write(fos);
			System.out.println("파일 출력이 완료되었습니다.");
		} catch (IOException e) {
			System.out.println("파일 출력에 실패하였습니다.");
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private void insertData() {
		String memId;
		while (true) {
			System.out.print("추가할 ID 입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) > 0) {
				System.out.println("이미 존재하는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("PASSWORD 입력 : ");
		String memPass = scan.next();
		System.out.print("이름 입력 : ");
		String memName = scan.next();

		boolean regex;
		String memTel = "";
		while (true) {
			System.out.print("전화번호 입력 : ");
			memTel = scan.next();
			String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
			regex = Pattern.matches(pattern, memTel);
			if (regex) {
				break;
			} else {
				System.out.println("전화번호 형식이 틀렸습니다.");
			}
		}

		System.out.print("주소 입력 : ");
		String memAddr = scan.next();

		// 입력한 데이터가 저장될 VO객체 생성
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(memId);
		memberVO.setMemPass(memPass);
		memberVO.setMemName(memName);
		memberVO.setMemTel(memTel);
		memberVO.setMemAddr(memAddr);

		int cnt = service.insertMember(memberVO);
		if (cnt > 0) {
			System.out.println("회원 추가 성공");
		} else {
			System.out.println("회원 추가 실패");
		}
	}

	private void deleteData() {
		String memId = "";
		while (true) {
			System.out.print("삭제할 ID입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		int cnt = service.deleteMember(memId);
		if (cnt > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private void updateData() {
		String memId = "";
		while (true) {
			System.out.print("수정할 ID 입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("변경할 Password 입력 : ");
		String memPass = scan.next();
		System.out.print("변경할 이름 입력 : ");
		String memName = scan.next();
		System.out.print("변경할 전화번호 입력 : ");
		String memTel = scan.next();
		System.out.print("변경할 주소 입력 : ");
		String memAddr = scan.next();
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(memId);
		memberVO.setMemPass(memPass);
		memberVO.setMemName(memName);
		memberVO.setMemTel(memTel);
		memberVO.setMemAddr(memAddr);

		int cnt = service.updateMember(memberVO);
		if (cnt > 0) {
			System.out.println("회원정보 수정완료");
		} else {
			System.out.println("회원정보 수정실패");
		}
	}

	private void getAllMemberList() {
		System.out.println("\n--------------------회원 목록--------------------");
		System.out.println("ID\tPASS\t이름\t전화번호\t\t주소");
		System.out.println("------------------------------------------------");
		List<MemberVO> list = service.getAllMemberList();
		for (MemberVO vo : list) {
			System.out.println(vo.getMemId() + "\t" + vo.getMemPass() + "\t" + vo.getMemName() + "\t" + vo.getMemTel()
					+ "\t" + vo.getMemAddr());
		}
		System.out.println("------------------------------------------------\n");
	}

	private void updateData2() {
		String memId = "";
		while (true) {
			System.out.print("수정할 ID 입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		String updateField = "";
		String dataTitle = "";
		int num;
		do {
			System.out.println("------------------------------------------");
			System.out.println("1.비밀번호		2.이름 	  3.전화번호		4.주소");
			System.out.println("------------------------------------------");
			System.out.print("수정 항목 선택 : ");
			num = scan.nextInt();
			switch (num) {
			case 1:
				updateField = "MEM_PASS";
				dataTitle = "비밀번호";
				break;
			case 2:
				updateField = "MEM_NAME";
				dataTitle = "이름";
				break;
			case 3:
				updateField = "MEM_TEL";
				dataTitle = "전화번호";
				break;
			case 4:
				updateField = "MEM_ADDR";
				dataTitle = "주소";
				break;
			default:
				System.out.println("수장할 항목을 잘못 선택했습니다.");
				System.out.println("다시 선택하세요");
			}
		} while (num < 1 || num > 4);
		System.out.print("새로운 " + dataTitle + "를 입력하세요 : ");
		String updateData = scan.next();

		// 선택한 컬럼명, 입력한 데이터, 회원ID를 Map객체에 저장한다.
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("memId", memId);
		paraMap.put("field", updateField);
		paraMap.put("data", updateData);
		int count = service.updateMember2(paraMap);
		if (count > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	// private void updateData2() {
	// String memId = "";
	// while (true) {
	// System.out.print("수정할 ID 입력 : ");
	// memId = scan.next();
	// if (service.getMeberCount(memId) == 0) {
	// System.out.println("존재하지 않는 ID입니다.");
	// } else {
	// break;
	// }
	// }
	// String dataType = "";
	// String dataTitle = "";
	// int num;
	// do {
	// System.out.println("------------------------------------------");
	// System.out.println("1.비밀번호 2.이름 3.전화번호 4.주소");
	// System.out.println("------------------------------------------");
	// System.out.print("수정 항목 선택 : ");
	// num = scan.nextInt();
	// switch (num) {
	// case 1:
	// dataType = "MEM_PASS";
	// dataTitle = "비밀번호";
	// break;
	// case 2:
	// dataType = "MEM_NAME";
	// dataTitle = "이름";
	// break;
	// case 3:
	// dataType = "MEM_TEL";
	// dataTitle = "전화번호";
	// break;
	// case 4:
	// dataType = "MEM_ADDR";
	// dataTitle = "주소";
	// break;
	// default:
	// System.out.println("수장할 항목을 잘못 선택했습니다.");
	// System.out.println("다시 선택하세요");
	// }
	// } while (num < 1 || num > 4);
	// System.out.print("새로운 " + dataTitle + "를 입력하세요 : ");
	// String updateData = scan.next();
	// int count = service.updateMember2(dataType, updateData, memId);
	// if (count > 0) {
	// System.out.println("수정 성공");
	// } else {
	// System.out.println("수정 실패");
	// }
	// }
}
