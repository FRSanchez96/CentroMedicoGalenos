/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Felipe
 */
public class HorarioSemanal {
    private int IdHoraSema, IdSucu, IdDia, HorasiDHora;

    public HorarioSemanal() {
    }

    public HorarioSemanal(int IdHoraSema, int IdSucu, int IdDia, int HorasiDHora) {
        this.IdHoraSema = IdHoraSema;
        this.IdSucu = IdSucu;
        this.IdDia = IdDia;
        this.HorasiDHora = HorasiDHora;
    }

    public int getIdHoraSema() {
        return IdHoraSema;
    }

    public void setIdHoraSema(int IdHoraSema) {
        this.IdHoraSema = IdHoraSema;
    }

    public int getIdSucu() {
        return IdSucu;
    }

    public void setIdSucu(int IdSucu) {
        this.IdSucu = IdSucu;
    }

    public int getIdDia() {
        return IdDia;
    }

    public void setIdDia(int IdDia) {
        this.IdDia = IdDia;
    }

    public int getHorasiDHora() {
        return HorasiDHora;
    }

    public void setHorasiDHora(int HorasiDHora) {
        this.HorasiDHora = HorasiDHora;
    }
    
    
}
