package CreateUserpj;

import java.util.List;

public class Mainpojo
{
	private int id;
	private PetCategory cate;
	private String name;
	private List<String>photoUrls;
	private List <PetTags> tag;
	private String status="available";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory getCate() {
		return cate;
	}
	public void setCate(PetCategory cate) {
		this.cate = cate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<PetTags> getTag() {
		return tag;
	}
	public void setTag(List<PetTags> tag) {
		this.tag = tag;
	
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
