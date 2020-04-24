package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.Video;

public class VideoModel {
	Connection con;
	public VideoModel() throws Exception {
		con=DBCon.getConnection();
	}
	public Video selectbyPk(int no) throws Exception {
		Video vo=new Video();
		String sql="select * from vinfo where vicode="+no;
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			vo.setVideoNo(Integer.parseInt(rs.getString("VICODE")));
			vo.setActor(rs.getString("ACTOR"));
			vo.setDirector(rs.getString("DIRECTOR"));
			vo.setGenre(rs.getString("GENRE"));
			vo.setVideoName(rs.getString("TITLE"));
			vo.setExp(rs.getString("DETAIL"));
		}
		rs.close();
		pstmt.close();
		return vo;
	}
}
