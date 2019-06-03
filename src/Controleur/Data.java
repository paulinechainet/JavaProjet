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
        SetDataClasses();
        SetDataBulletins();
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
      for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) 
      {
          Personne p = entry.getValue();
          System.out.println(p.getNom());
      }  
      
    }
    public Personne searchp(String rech)
    {
        Personne p;
        int a = 0;
        int cle = 0;
        String nom = null;
        String Prenom = null;
        int i=0;
       for(Map.Entry<Integer, Personne> entry : tablePersonnes.entrySet()) 
      {

          p = entry.getValue();
          if(p.getNom().equals(rech) || p.getPrenom().equals(rech))
          {
              a = 1;
              cle = p.getId();
              nom = p.getNom();
              Prenom = p.getPrenom();
          }
          
      }
       if(a == 0)
       {
       p = new Personne();
       }
       else
       {
          p = new Personne(cle,nom,Prenom);
       }
       return p;
    }
    public void addp(int id, String nom, String prenom)
    {
        Personne p = new Personne(id,nom,prenom);
        tablePersonnes.put(id, p);
        SavePersonne();
        tablePersonnes.clear();
        LoadPersonne();
        
        
    }
    public void modifp(int id, String nom, String prenom)
    {
      Personne p = new Personne(id,nom,prenom);
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
}
