/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Annee;
import Modele.Bulletin;
import Modele.Classe;
import Modele.Discipline;
import Modele.Enseignement;
import Modele.Evaluation;
import Modele.Inscription;
import Modele.Niveau;
import Modele.Personne;
import Modele.Trimestre;
import Modele.Detail;
import Modele.Ecole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author paulinechainet
 */
public class Data {
    private Map<Integer,Annee> tableAnnees = new HashMap<Integer,Annee>();
    private Map<Integer,Bulletin> tableBulletins = new HashMap<Integer,Bulletin>();
    private Map<Integer,Classe> tableClasses = new HashMap<Integer,Classe>();
    private Map<Integer,Discipline> tableDisciplines = new HashMap<Integer,Discipline>();
   private Map<Integer,Personne> tablePersonnes =new HashMap<Integer,Personne>();
    private Map<Integer,Enseignement> tableEnseignements = new HashMap<Integer,Enseignement>();
    private Map<Integer,Evaluation> tableEvaluations = new HashMap<Integer,Evaluation>();
    private Map<Integer,Inscription> tableInscriptions = new HashMap<Integer,Inscription>();
    private Map<Integer,Niveau> tableNiveaux = new HashMap<Integer,Niveau>();
    private Map<Integer,Trimestre> tableTrimestres = new HashMap<Integer,Trimestre>();
    private Map<Integer,Detail> tableDetail = new HashMap<Integer,Detail>();
   
    public Data() {
      
    }
    public void LoadAllData()
    {
        
        LoadAnnee();
        LoadBulletin();
        LoadClasse();
        LoadDiscipline();
        LoadPersonne();
        LoadEnseignement();
        LoadEvaluation();
        LoadInscription();
        LoadNiveau();
        LoadTrimestre();
        LoadDetail();
        //SetDataClasses();
        //SetDataBulletins();
    }
      public void Save_All_Data()
    {
        SaveAnnee();
        SaveBulletin();
        SaveClasse();
        SaveDiscipline();
        SavePersonne();
        SaveEnseignement();
        SaveEvaluation();
        SaveInscription();
        SaveNiveau();
        SaveTrimestre();
    }
        
    private void LoadAnnee()
    {
        DAO<Annee> DAO= DAOFactory.getDAO_Annee();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Annee a = DAO.find(i);
                tableAnnees.put(a.getId(),a);
            }
        }
    }
    
    
     private void LoadBulletin()
    {
        DAO<Bulletin> DAO= DAOFactory.getDAO_Bulletin();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Bulletin a = DAO.find(i);
                tableBulletins.put(a.getId(),a);
            }
        }
    }
     private void LoadDetail()
    {
        DAO<Detail> DAO= DAOFactory.getDAO_Detail();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Detail a = DAO.find(i);
                tableDetail.put(a.getId(),a);
            }
        }
    }
     
      private void LoadClasse()
    {
        DAO<Classe> DAO= DAOFactory.getDAO_Classe();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Classe a = DAO.find(i);
                tableClasses.put(a.getId(),a);
            }
        }
    }
    
        
    private void LoadDiscipline()
    {
        DAO<Discipline> DAO= DAOFactory.getDAO_Discipline();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Discipline a = DAO.find(i);
                tableDisciplines.put(a.getId(),a);
            }
        }
    }
      private void LoadPersonne()
    {
        DAO<Personne> DAO= DAOFactory.getDAO_Personne();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Personne a = DAO.find(i);
                tablePersonnes.put(a.getId(),a);
            }
        }
    }
    
    private void LoadEnseignement()
    {
        DAO<Enseignement> DAO= DAOFactory.getDAO_Enseignement();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Enseignement a = DAO.find(i);
                tableEnseignements.put(a.getId(),a);
            }
        }
    }
     private void LoadEvaluation()
    {
        DAO<Evaluation> DAO= DAOFactory.getDAO_Evaluation();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Evaluation a = DAO.find(i);
                tableEvaluations.put(a.getId(),a);
            }
        }
    }
    
    private void LoadInscription()
    {
        DAO<Inscription> DAO= DAOFactory.getDAO_Inscription();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Inscription a = DAO.find(i);
                tableInscriptions.put(a.getId(),a);
            }
        }
    }
    
    private void LoadNiveau()
    {
        DAO<Niveau> DAO= DAOFactory.getDAO_Niveau();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Niveau a = DAO.find(i);
                tableNiveaux.put(a.getId(),a);
            }
        }
    }
    
    private void LoadTrimestre()
    {
        DAO<Trimestre> DAO= DAOFactory.getDAO_Trimestre();
        for(int i =1;i<DAO.getMaxId()+1;i++)
        {
            if(DAO.find(i) != null)
            {
                Trimestre a = DAO.find(i);
                tableTrimestres.put(a.getId(),a);
            }
        }
    }
    
    private void SaveAnnee()
    {
        DAO<Annee> DAO= DAOFactory.getDAO_Annee();
        for(Map.Entry<Integer, Annee> entry : tableAnnees.entrySet()) {  
            Annee a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
            
        }
    }
    private void SaveDetail()
    {
        DAO<Detail> DAO= DAOFactory.getDAO_Detail();
        for(Map.Entry<Integer, Detail> entry : tableDetail.entrySet()) {  
            Detail a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
            
        }
    }
    
    private void SaveBulletin()
    {
        DAO<Bulletin> DAO= DAOFactory.getDAO_Bulletin();
        for(Map.Entry<Integer, Bulletin> entry : tableBulletins.entrySet()) {  
            Bulletin a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    private void SaveClasse()
    {
        DAO<Classe> DAO= DAOFactory.getDAO_Classe();
        for(Map.Entry<Integer, Classe> entry : tableClasses.entrySet()) {  
            Classe a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
     private void SaveDiscipline()
    {
        DAO<Discipline> DAO= DAOFactory.getDAO_Discipline();
        for(Map.Entry<Integer, Discipline> entry : tableDisciplines.entrySet()) {  
            Discipline a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    private void SavePersonne()
    {
        DAO<Personne> DAO= DAOFactory.getDAO_Personne();
        for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) {  
            Personne a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
  
    private void SaveEnseignement()
    {
        DAO<Enseignement> DAO= DAOFactory.getDAO_Enseignement();
        for(Map.Entry<Integer, Enseignement> entry : tableEnseignements.entrySet()) {  
            Enseignement a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    private void SaveEvaluation()
    {
        DAO<Evaluation> DAO= DAOFactory.getDAO_Evaluation();
        for(Map.Entry<Integer, Evaluation> entry : tableEvaluations.entrySet()) {  
            Evaluation a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    private void SaveInscription()
    {
        DAO<Inscription> DAO= DAOFactory.getDAO_Inscription();
        for(Map.Entry<Integer, Inscription> entry : tableInscriptions.entrySet()) {  
            Inscription a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    private void SaveNiveau()
    {
        DAO<Niveau> DAO= DAOFactory.getDAO_Niveau();
        for(Map.Entry<Integer, Niveau> entry : tableNiveaux.entrySet()) {  
            Niveau a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
   
    private void SaveTrimestre()
    {
        DAO<Trimestre> DAO= DAOFactory.getDAO_Trimestre();
        for(Map.Entry<Integer, Trimestre> entry : tableTrimestres.entrySet()) {  
            Trimestre a = entry.getValue();
            if(DAO.find(a.getId())!=null)
            {
                DAO.update(a);
            }else{
                DAO.create(a);
            }
        }
    }
    

    public Map<Integer, Annee> getAnnees() {
        return tableAnnees;
    }
     public Map<Integer, Bulletin> getBulletins() {
        return tableBulletins;
    }

    public Map<Integer, Classe> getClasses() {
        return tableClasses;
    }
    public ArrayList<Classe> getallC(){
        Classe c;
        ArrayList <Classe> tabc = new ArrayList();
       for(Map.Entry<Integer, Classe> entry : tableClasses.entrySet()) 
      {
          c = entry.getValue();
          tabc.add(c);
      }
       return tabc;
    }
    public ArrayList<Evaluation> getallEv(){
        Evaluation e;
        ArrayList <Evaluation> tabe = new ArrayList();
       for(Map.Entry<Integer, Evaluation> entry : tableEvaluations.entrySet()) 
      {
          e = entry.getValue();
          tabe.add(e);
      }
       return tabe;
    }
    public ArrayList<Niveau> getallNiv(){
        Niveau e;
        ArrayList <Niveau> tabe = new ArrayList();
       for(Map.Entry<Integer, Niveau> entry : tableNiveaux.entrySet()) 
      {
          e = entry.getValue();
          tabe.add(e);
      }
       return tabe;
    }
    public ArrayList<Bulletin> getallB(){
        Bulletin b;
        ArrayList <Bulletin> tabb = new ArrayList();
       for(Map.Entry<Integer, Bulletin> entry : tableBulletins.entrySet()) 
      {
          b = entry.getValue();
          tabb.add(b);
      }
       return tabb;
    }
    public ArrayList<Discipline> getallDis(){
        Discipline d;
        ArrayList <Discipline> tabd = new ArrayList();
       for(Map.Entry<Integer, Discipline> entry : tableDisciplines.entrySet()) 
      {
          d = entry.getValue();
          tabd.add(d);
      }
       return tabd;
    }

    public Map<Integer, Discipline> getDisciplines() {
        return tableDisciplines;
    }

    public Map<Integer, Personne> getPersonne() {
        return tablePersonnes;
    }

    public Map<Integer, Enseignement> getEnseignements() {
        return tableEnseignements;
    }

    public Map<Integer, Evaluation> getEvaluations() {
        return tableEvaluations;
    }

    public Map<Integer, Inscription> getInscriptions() {
        return tableInscriptions;
    }

    public Map<Integer, Niveau> getNiveaux() {
        return tableNiveaux;
    }

    public Map<Integer, Trimestre> getTrimestres() {
        return tableTrimestres;
    }
    public void affichage()
    {
      for(Map.Entry<Integer, Evaluation> entry : tableEvaluations.entrySet()) 
      {
          Evaluation p = entry.getValue();
          System.out.println(p.getBulletin().getId());
      }  
      
    }
    public Detail searchd(int id)
    {
        Detail t,t1 = null;
        Bulletin b;
        Enseignement e;
        for(Map.Entry<Integer, Detail> entry : tableDetail.entrySet())
        {
          t = entry.getValue();
          b = t.getBulletin();
          System.out.print(id);
          System.out.print(b.getId());
          if(b.getId() == id)
          {
              t1 = t;
          }
        }
        return t1;
    }
    public Classe inscrit(int id)
    {
        Classe c= null;
        Inscription i;
        Personne p;
        String s;
        for(Map.Entry<Integer, Inscription> entry : tableInscriptions.entrySet())
        {
          i = entry.getValue();
          p = i.getPersonne();
          if(p.getId() == id)
          {
              c = i.getClasse();
          }
        }
        return c;
        
    }
    public Trimestre searcht(int trimestre, int annee)
    {
        Trimestre t,t1 = null;
        Annee a;
        for(Map.Entry<Integer, Trimestre> entry : tableTrimestres.entrySet())
        {
          t = entry.getValue();
          a = t.getAnnee();
          if(a.getId() == annee && t.getNumero() == trimestre)
          {
              t1 = t;
          }
        }
        return t1;
    }
    public Inscription searchinscrit(int id)
    {
        Inscription i,i1 = null;
        Personne p = null;
        Classe c;
         for(Map.Entry<Integer, Inscription> entry : tableInscriptions.entrySet()) 
      {

          i = entry.getValue();
          p = i.getPersonne();
          if(p.getId() == id)
          {
           c = i.getClasse(); 
           i1 = new Inscription(i.getId(),p,c);
          }
          
      }
         return i1;
        
    }
    public Niveau searchn(String s)
    {
        Niveau i,i1 = null;
         for(Map.Entry<Integer, Niveau> entry : tableNiveaux.entrySet()) 
      {

          i = entry.getValue();
          if(i.getNom() == s)
          {
            i1 = i;
          }
    }
         return i1;
    }
    public ArrayList<Evaluation> searchNote(int idb)
    {
        Evaluation e = null;
        ArrayList <Evaluation> tabe = new ArrayList();
      for(Map.Entry<Integer, Evaluation> entry : tableEvaluations.entrySet()) 
      {
          e = entry.getValue();
          if(e.getBulletin().getId() == idb){
              tabe.add(e);
          }
      }
      return tabe;
    }
    public Personne searche(int id)
    {
        Inscription i;
        Personne p = null;
        for(Map.Entry<Integer, Inscription> entry : tableInscriptions.entrySet()) 
      {

          i = entry.getValue();
          if(i.getId() == id)
          {
           p = i.getPersonne();
          }
          
      }
         return p;
    }
    public void addenseignement( Classe classe, Personne personne, Discipline discipline)
    {
       DAO<Enseignement> DAO= DAOFactory.getDAO_Enseignement();
       Enseignement e = new Enseignement(DAO.getMaxId()+1,classe,personne,discipline); 
       System.out.println(personne.getNom());
       System.out.println(classe.getNom());
       System.out.println(discipline.getNom());
       tableEnseignements.put(DAO.getMaxId(), e);
       SaveEnseignement();
    }
    public ArrayList<Classe> searchclasseid(int id)
    {
        Enseignement e;
        Classe c;
        ArrayList<Classe> tabc = new ArrayList();
        Personne p;
        for(Map.Entry<Integer, Enseignement> entry : tableEnseignements.entrySet()) 
      {
          e = entry.getValue();
          c = e.getClasse();
          p = e.getPersonne();
          if(p.getId() == id)
          {
              tabc.add(c);
          }
      }
        return tabc;
    }
    public void modifinscrit(String nom,int id,Classe c,Personne p)
    {
        Inscription i;
        Classe c1;
        
        i = searchinscrit(p.getId());
        
        if(i!=null)
        {
            i.setClasse(c);
        }
        if(i==null)
        {
            DAO<Inscription> DAO= DAOFactory.getDAO_Inscription();
            i = new Inscription(DAO.getMaxId()+1,p,c);
        }

      if(i.getClasse()!=null){
      tableInscriptions.put(i.getId(),i);
      SaveInscription();
      }
    }
    public ArrayList<Personne> getE()
    {
        ArrayList<Personne> e = new ArrayList();
        Personne p;
        for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) 
      {
          p = entry.getValue();
          if(p.getType() == 1){
              e.add(p);
          }
      }
        return e;
    }
    public ArrayList<Personne> getP()
    {
        ArrayList<Personne> e = new ArrayList();
        Personne p;
        for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) 
      {
          p = entry.getValue();
          if(p.getType() != 1){
              e.add(p);
          }
      }
        return e;
    }
    public Discipline searchdiscipline(Personne p)
    {
        Discipline di = null;
        Enseignement e;
        for(Map.Entry<Integer, Enseignement> entry : tableEnseignements.entrySet()) 
      {
          e = entry.getValue();
          if(e.getPersonne().getId() == p.getId()){
              di = e.getDiscipline();
          }
      }
        return di;
    }
    public Bulletin searchbulletin(int idi, int idt)
    {
        Bulletin b,b1 = null;
        Inscription i;
        Trimestre t;
        String s;
        int a =0;
         for(Map.Entry<Integer, Bulletin> entry : tableBulletins.entrySet()) 
      {

          b = entry.getValue();
          i = b.getInscription();
          t = b.getTrimestre();
          if(i.getId() == idi && t.getId() == idt)
          {
              s = b.getapre();
              t = b.getTrimestre();
              a = b.getmoy();
              b1 = new Bulletin(b.getId(),i,t,s,a);
          }
          
      }
         return b1;
         
    }
    public Personne searchp(String rech)
    {
        Personne p;
        int a = 0;
        int cle = 0;
        String nom = null;
        String Prenom = null;
        int i = 0;
       for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) 
      {

          p = entry.getValue();
          if(p.getNom().equals(rech) || p.getPrenom().equals(rech))
          {
              a = 1;
              cle = p.getId();
              nom = p.getNom();
              Prenom = p.getPrenom();
              i = p.getType();
          }
          
      }
       if(a == 0)
       {
       p = new Personne();
       }
       else
       {
          p = new Personne(cle,nom,Prenom,i);
       }
       return p;
    }
    public Classe searchc(String rech,int id)
    {
        Classe c;
        int a = 0;
        int cle = 0;
        String nom = null;
        Annee an = null;
        Niveau n = null;
       for(Map.Entry<Integer, Classe> entry : tableClasses.entrySet()) 
      {

          c = entry.getValue();
          if(c.getan() == id && c.getNom().equals(rech))
          {
              a = 1;
              cle = c.getId();
              nom = c.getNom();
              an = c.getAnnee();
              n = c.getNiveau();
          }
          
      }
       if(a == 0)
       {
       c = new Classe();
       }
       else
       {
          c = new Classe(cle,nom,n,an);
       }
       return c;
    }
    public void addc(String nom,String n, int a)
    {
        Annee an = new Annee(a);
        Niveau niv = searchn(nom);
        DAO<Classe> DAO= DAOFactory.getDAO_Classe();
        Classe c = new Classe(DAO.getMaxId()+1,n,niv,an);
        tableClasses.put(DAO.getMaxId()+1, c);
        SaveClasse(); 
    }
    public void addp(int id, String nom, String prenom, int type)
    {
        Personne p = new Personne(id,nom,prenom,type);
        tablePersonnes.put(id, p);
        SavePersonne();
        tablePersonnes.clear();
        LoadPersonne(); 
    }
    public void modifp(int id, String nom, String prenom, int type)
    {
      Personne p = new Personne(id,nom,prenom,type);
      tablePersonnes.remove(id);
      tablePersonnes.put(id, p);
      SavePersonne();
    }
    public void supprp(int id)
    {
        Personne p = tablePersonnes.get(id);
        tablePersonnes.remove(id);
        DAO<Personne> DAO= DAOFactory.getDAO_Personne();
        DAO.delete(p);
    }
    public void SetDataBulletins()
    {
        for(Map.Entry<Integer,Bulletin> bull : tableBulletins.entrySet())
        {
            Bulletin b = bull.getValue();
            Personne p = tablePersonnes.get(b.getPersonne().getId());
            p.getBulletins().add(b);
            for(Map.Entry<Integer,Evaluation> evaluat : tableEvaluations.entrySet())
            {
                Evaluation ev = evaluat.getValue();
                if(b.getId()==ev.getBulletin().getId())
                {
                    b.getEvaluation().add(ev);
                    
                }
            }
        }
    }
    public int nbeleves()
    {
       return tablePersonnes.size();
    }
    public void SetDataClasses()
    {
        for(Map.Entry<Integer,Inscription> inscri : tableInscriptions.entrySet())
        {
            Inscription i = inscri.getValue();
            Classe c = tableClasses.get(i.getClasse().getId());
            Personne p = tablePersonnes.get(i.getPersonne().getId());
            c.getPersonnes().add(p);
            p.setClasse(c);
        }
        
        for(Map.Entry<Integer,Enseignement> enseignement : tableEnseignements.entrySet())
        {
            Enseignement m = enseignement.getValue();
            Classe c = tableClasses.get(m.getClasse().getId());
            Personne p = tablePersonnes.get(m.getPersonne().getId());
            Discipline d = tableDisciplines.get(m.getDiscipline().getId());
            if(!c.getPersonnes().contains(p))
            {
                c.getPersonnes().add(p);
            }
            if(!p.getALClasse().contains(c))
            {
                p.getALClasse().add(c);
            }
            
            if(!p.getDiscipline().contains(d))
            {
                p.getDiscipline().add(d);
            }
            
            if(!c.getDisciplines().contains(d))
            {
                c.getDisciplines().add(d);
            }
                
        }
    }

    public void addisci(String text) {
        DAO<Discipline> DAO= DAOFactory.getDAO_Discipline();
        Discipline d = new Discipline(DAO.getMaxId()+1,text);
        tableDisciplines.put(DAO.getMaxId()+1,d);
        SaveDiscipline();
        
    }
   /* public void addschool(String text) {
        DAO<Ecole> DAO= DAOFactory.getDAO_Ecole();
        Ecole E = new Ecole(DAO.getMaxId()+1,text);
        tableEcoles.put(DAO.getMaxId()+1,E);
        SaveEcole();
        
    }*/

    public void addeval(int note, String a, Detail b, Personne el) {
        //int id, int note, String appreciation, Detail bulletin,Personne enseignant
                DAO<Evaluation> DAO = DAOFactory.getDAO_Evaluation();
                Evaluation e = new Evaluation(DAO.getMaxId()+1,note,a,b,el);
                tableEvaluations.put(DAO.getMaxId()+1, e);
                SaveEvaluation();
                LoadEvaluation();
    }

    public void addb(Inscription inscription, Trimestre trimestre, String appreciation) {
        DAO<Bulletin> DAO= DAOFactory.getDAO_Bulletin();
        int moyenne = 10;
        Bulletin b = new Bulletin(DAO.getMaxId()+1,inscription,trimestre,"", moyenne);
        tableBulletins.put(DAO.getMaxId()+1, b);
        SaveBulletin();
    }
    public void addetail(Bulletin b, Enseignement e)
    {
        DAO<Detail> DAO= DAOFactory.getDAO_Detail();
        Detail d = new Detail(DAO.getMaxId()+1,b,e,"");
        tableDetail.put(DAO.getMaxId()+1, d);
        SaveDetail();
        
    }
    public Enseignement searchenseignement(String prof, String dis)
    {
        Enseignement e,e1 = null;
        for(Map.Entry<Integer,Enseignement> entry : tableEnseignements.entrySet())
        {
            e = entry.getValue();
            if(e.getPersonne().getNom().equals(prof) && e.getDiscipline().getNom().equals(dis))
            {
                e1 = e;
            }
        }
        return e1;
    }

    public Detail searchde(Bulletin b, Enseignement e) {
        Detail d,d1 = null;
        for(Map.Entry<Integer,Detail> entry : tableDetail.entrySet())
        {
            d = entry.getValue();
            if(d.getBulletin().getId() == b.getId() && d.getEnseignement().getId() == e.getId())
            {
                d1 = d;
            }
        }
        return d1;
    }
}
