package modelo.vo;
    
public class PersonaVo {
	
	private Integer idPersona;
	private String nombrePersona;
	private Integer edadPersona;
	private String profesionPersona;
	private Integer telefonoPersona;

    public PersonaVo(Integer idPersona, String nombrePersona, Integer edadPersona, String profesionPersona, Integer telefonoPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.edadPersona = edadPersona;
        this.profesionPersona = profesionPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public PersonaVo() {
    }

  
//    public PersonaVo(int i, String alvaro_Suarez, int i0, String instructor, int i1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
	
	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}
	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}
	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	/**
	 * @return the edadPersona
	 */
	public Integer getEdadPersona() {
		return edadPersona;
	}
	/**
	 * @param edadPersona the edadPersona to set
	 */
	public void setEdadPersona(Integer edadPersona) {
		this.edadPersona = edadPersona;
	}
	/**
	 * @return the profesionPersona
	 */
	public String getProfesionPersona() {
		return profesionPersona;
	}
	/**
	 * @param profesionPersona the profesionPersona to set
	 */
	public void setProfesionPersona(String profesionPersona) {
		this.profesionPersona = profesionPersona;
	}
	/**
	 * @return the telefonoPersona
	 */
	public Integer getTelefonoPersona() {
		return telefonoPersona;
	}
	/**
	 * @param telefonoPersona the telefonoPersona to set
	 */
	public void setTelefonoPersona(Integer telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	

}
