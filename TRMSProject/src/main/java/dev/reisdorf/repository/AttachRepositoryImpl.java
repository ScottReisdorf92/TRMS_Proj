package dev.reisdorf.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.reisdorf.model.EmpAttach;
import dev.reisdorf.util.JDBCConnection;

public class AttachRepositoryImpl implements AttachRepository {

	private static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public EmpAttach addAttachment(EmpAttach attach) {
		try {
			String sql = "INSERT INTO attachments VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(attach.getFormId()));
			ps.setString(2, attach.getAttachment());
			
			ps.executeQuery();
			return attach;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpAttach> getAllAttachments() {
		try {
			String sql = "SELECT * FROM attachments";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<EmpAttach> attachments = new ArrayList<EmpAttach>();
			while(rs.next()) {
				EmpAttach a = new EmpAttach();
				a.setFormId(rs.getInt("FORM_ID"));
				a.setAttachment(rs.getString("ATTACHMENT"));
				attachments.add(a);
			}
			return attachments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmpAttach> getAllFormAttachments(int id) {
		try {
			String sql = "SELECT * FROM attachments WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			ResultSet rs = ps.executeQuery();
			List<EmpAttach> attachments = new ArrayList<EmpAttach>();
			while(rs.next()) {
				EmpAttach a = new EmpAttach();
				a.setFormId(rs.getInt("FORM_ID"));
				a.setAttachment(rs.getString("ATTACHMENT"));
				attachments.add(a);
			}
			return attachments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAttachment(int id, String attachName) {
		try {
			String sql = "DELETE FROM attachments WHERE form_id = ? AND attachment = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ps.setString(2, attachName);
			
			
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFormAttachments(int id) {
		try {
			String sql = "DELETE FROM attachments WHERE form_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			
			
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
