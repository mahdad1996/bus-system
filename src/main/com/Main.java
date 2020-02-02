package main.com;


import main.com.team3d.busTravelingSystem.Persistent.DbContext.HibernateUtil;
import org.hibernate.Session;



public class Main {
    public static void main(String[] args){

        Session hibernateUtil = HibernateUtil.getSession();


    }
}
