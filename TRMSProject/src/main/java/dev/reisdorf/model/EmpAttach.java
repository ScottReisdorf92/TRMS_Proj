package dev.reisdorf.model;

public class EmpAttach {
	
	// INSTANCE VARIABLES //
	private int formId;
	private String attachment;
	
	// CONSTRUCTORS //
	public EmpAttach() {
		super();
	}
	
	//----- GETTERS AND SETTERS -----/
	public EmpAttach(int formId, String attachment) {
		super();
		this.formId = formId;
		this.attachment = attachment;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "EmpAttach [formId=" + formId + ", attachment=" + attachment + "]";
	}
	
	
}
