package controller;

import data.GrupoFamiliarDao;
import domain.GrupoFamiliar;
import java.sql.SQLException;
import java.util.List;

public class GrupoFamiliarController {

    private GrupoFamiliarDao grupoFamiliarDao;

    public GrupoFamiliarController() {
        grupoFamiliarDao = new GrupoFamiliarDao();
    }

    public List<GrupoFamiliar> obtenerGruposFamiliares() throws SQLException {
        return grupoFamiliarDao.obtenerGruposFamiliares();
    }

    public void crear(GrupoFamiliar grupoFamiliar) throws SQLException {
        grupoFamiliarDao.crear(grupoFamiliar);
    }

    public GrupoFamiliar obtenerGrupoFamiliar(int id) throws SQLException {
        return grupoFamiliarDao.obtenerGrupoFamiliar(id);
    }

    public void actualizarGrupoFamiliar(int id, GrupoFamiliar grupoFamiliar) throws SQLException {
        grupoFamiliarDao.actualizarGrupoFamiliar(id, grupoFamiliar);
    }

    public void eliminarGrupoFamiliar(int id) throws SQLException {
        grupoFamiliarDao.eliminarGrupoFamiliar(id);
    }
}

