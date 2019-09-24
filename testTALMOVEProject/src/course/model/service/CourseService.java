package course.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import course.model.dao.CourseDao;
import course.model.vo.Course;
import payment.model.vo.Payment;

public class CourseService {
	
	private CourseDao cDao = new CourseDao();
	
	//지우
	
	public Course courseDetailView( int courseNo)  {
		return null;} //상세 강좌 뷰
	public Payment directPay( int courseNo, int price)  {
		return null;} //바로 결제(강좌 수강)
	public Object playVideo( int courseNo, String lerctureOriginalFileName)  {
		return lerctureOriginalFileName;
		} //샘플동영상 재생

	//건우		
	//섹션의 개수 파악
	public int getSectionCount(int CourseNo) {
		Connection conn = getConnection();
		int SectionCount = cDao.getSectionCount(conn,CourseNo);
		close(conn);
		return SectionCount;
	}
	
	//섹션불러오기
	public ArrayList<Section> SectionList(int courseNo){
		Connection conn = getConnection();
		ArrayList<Section> result = cDao.getSectionList(conn, courseNo);
		if(result != null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	//렉쳐 불러오기
	public ArrayList<Lecture> LectureList(int sectionNo) {
		Connection conn = getConnection();
		ArrayList<Lecture> result = cDao.getLectureList(conn, sectionNo);
		if(result != null) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	//건우
	public Course getCourse(int courseNumber) {
		Connection conn = getConnection();
		Course course = cDao.getCourse(conn, courseNumber);
		close(conn);
		return course;
	public ArrayList<Course> CourseLoad( int courseNo, Course course){
		return null;}

	public int CourseSave( int courseNo,Course course){
		return courseNo;}


	public int CourseCreate( int courseNo,Course course){
		return courseNo;}



	public String NameChange( int courseNo,Course course, String newname){
		return newname;}



	public int AttachmentEnroll( int courseNo,Course course){
		return courseNo;}


	public int AttachmentDelete( int courseNo,Course course){
		return courseNo;}



	public Object  VideoUpload( int courseNo,Course course,Object video){
		return video;}



	public int VideoDelete( int courseNo,Course course, Object video){
		return courseNo;}
	
	//학열
	public ArrayList<Course>selectCourse (int courseNo){
		return null;}

	//강좌 정렬
	public ArrayList<Course> sortCourse (int courseNo){
		return null;}
	
	//강사페이지에서 저장한 강좌 기본정보 저장하기(관익)
	public int setCourseBasic(Course course) {
		Connection conn = getConnection();
		int result = cDao.setCourseBasic(conn, course);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public Course getCourseByName(String courseName) {
		Connection conn = getConnection();
		Course course = cDao.getCourseByName(conn, courseName);
		close(conn);
		return course;
	}
	public ArrayList<Course> getCourseListByTNo(int teacherNo) {
		Connection conn = getConnection();
		ArrayList<Course> courseList = cDao.getCourseListByTNo(conn, teacherNo);
		close(conn);
		return courseList;
	}
	public int setCourseOpen(int courseNo, int price) {
		Connection conn = getConnection();
		int result = cDao.setCourseOpen(conn, courseNo, price);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int deleteCourse(int courseNo) {
		Connection conn = getConnection();
		int result = cDao.deleteCourse(conn, courseNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
