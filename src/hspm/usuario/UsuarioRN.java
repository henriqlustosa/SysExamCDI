package hspm.usuario;
import java.util.Date;
//import java.util.Date;
import java.util.List;


import hspm.util.DAOFactory;


public class UsuarioRN {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN(){
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Integer codigo = usuario.getCodigo();
		if(codigo == null || codigo == 0){
			usuario.getPermissao().add("ROLE_USUARIO");	
			usuario.setDtCadastro(new Date());
			this.usuarioDAO.salvar(usuario);
		}else{
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario){
		//CategoriaRN categoriaRN = new CategoriaRN();
		//categoriaRN.excluir(usuario);
		
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}