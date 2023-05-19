package data;

import domain.GrupoFamiliar;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliarDao {

    private static final String GET_GRUPO_FAMILIAR = "SELECT * FROM GrupoFamiliar";

    private static final String CREATE_GRUPO_FAMILIAR = "INSERT INTO GrupoFamiliar (funcionarioid, nombres, apellidos, parentesco) "
            + "VALUES (?, ?, ?, ?)";

    private static final String GET_GRUPO_FAMILIAR_BY_ID = "SELECT * FROM GrupoFamiliar WHERE id = ?";

    private static final String UPDATE_GRUPO_FAMILIAR = "UPDATE GrupoFamiliar SET funcionarioid = ?, nombres = ?, apellidos = ?, parentesco = ? "
            + "WHERE id = ?";

    private static final String DELETE_GRUPO_FAMILIAR = "DELETE FROM GrupoFamiliar WHERE id = ?";

    public List<GrupoFamiliar> obtenerGruposFamiliares() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<GrupoFamiliar> grupoFamiliarList = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_GRUPO_FAMILIAR);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
                grupoFamiliar.setId(resultSet.getInt("id"));
                grupoFamiliar.setFuncionarioId(resultSet.getInt("funcionarioid"));
                grupoFamiliar.setNombres(resultSet.getString("nombres"));
                grupoFamiliar.setApellidos(resultSet.getString("apellidos"));
                grupoFamiliar.setParentesco(resultSet.getString("parentesco"));

                grupoFamiliarList.add(grupoFamiliar);
            }

            return grupoFamiliarList;
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(GrupoFamiliar grupoFamiliar) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_GRUPO_FAMILIAR);
            preparedStatement.setInt(1, grupoFamiliar.getFuncionarioId());
            preparedStatement.setString(2, grupoFamiliar.getNombres());
            preparedStatement.setString(3, grupoFamiliar.getApellidos());
            preparedStatement.setString(4, grupoFamiliar.getParentesco());

            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public GrupoFamiliar obtenerGrupoFamiliar(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        GrupoFamiliar grupoFamiliar = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_GRUPO_FAMILIAR_BY_ID);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                grupoFamiliar = new GrupoFamiliar();
                grupoFamiliar.setId(resultSet.getInt("id"));
                grupoFamiliar.setFuncionarioId(resultSet.getInt("funcionarioid"));
                grupoFamiliar.setNombres(resultSet.getString("nombres"));
                grupoFamiliar.setApellidos(resultSet.getString("apedllios"));
                grupoFamiliar.setParentesco(resultSet.getString("parentesco"));
            }

            return grupoFamiliar;
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarGrupoFamiliar(int id, GrupoFamiliar grupoFamiliar) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_GRUPO_FAMILIAR);
            preparedStatement.setInt(1, grupoFamiliar.getFuncionarioId());
            preparedStatement.setString(2, grupoFamiliar.getNombres());
            preparedStatement.setString(3, grupoFamiliar.getApellidos());
            preparedStatement.setString(4, grupoFamiliar.getParentesco());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarGrupoFamiliar(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_GRUPO_FAMILIAR);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
