package ro.mycode.PantofiSport.view;

import org.springframework.stereotype.Component;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportExistent;
import ro.mycode.PantofiSport.exceptii.ExceptiePantofiSportNeexistent;
import ro.mycode.PantofiSport.model.PantofiSport;
import ro.mycode.PantofiSport.pantofServices.PantofiSportService;

import java.util.List;
import java.util.Scanner;

@Component
public class View {

    private final PantofiSportService pantofiSportService;
    private final Scanner scanner;

    public View(PantofiSportService pantofiSportService){
        this.pantofiSportService = pantofiSportService;
        scanner = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("Apasa 1 pentru a afisa toti pantofii sport");
        System.out.println("Apasa 2 pentru a adauga o pereche de pantofi");
        System.out.println("Apasa 3 pentru a sterge o pereche de pantofi sport");
        System.out.println("Apasa 4 pentru a intra in meniul de update");
        System.out.println("Apasa 5 pentru a afisa produsele in ordine alfabetica A-Z");
        System.out.println("Apasa 6 pentru a afisa produsele in functie de pret crescator");
        System.out.println("Apasa 7 pentru a afisa produsele in functie de pret descrescator");
        System.out.println("Apasa 8 pentru a afisa produsele de gen feminin");
        System.out.println("Apasa 9 pentru a afisa produsele de gen masculin");
    }
    public void updateMenu(){
        System.out.println("Apasa 1 pentru a updata pretul");
        System.out.println("Apasa 2 pentru a updata stocul");
        System.out.println("Apasa 3 pentru a updata marimea");
        System.out.println("Apasa 0 pentru a te intoarce la meniul principal");
    }

    public void play(){
        boolean run = true;
        menu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    afisare();
                    break;
                case 2:
                    addPantofiSport();
                    break;
                case 3:
                    removePantofiSport();
                    break;
                case 4:
                    playUpdate();
                    break;
                case 5:
                    getPantofSportByNumeProdus();
                    break;
                case 6:
                    getPantofSportByPriceA();
                    break;
                case 7:
                    getPantofSportByPriceD();
                    break;
                case 8:
                    getPantofSportByGenF();
                    break;
                case 9:
                    getPantofSportByGenM();
                    break;
                default:
                    run = false;
                    break;
            }
        }
    }
    void playUpdate(){
        boolean run = true;
        updateMenu();
        while (run){
            int buton = Integer.parseInt(scanner.nextLine());
            switch (buton){
                case 1:
                    updatePantofSportPrice();
                    break;
                case 2:
                    updatePantofSportStoc();
                    break;
                case 3:
                    updatePantofSportMarime();
                    break;
                case 0:
                    play();
                    run = false;
                    break;
            }
        }
    }

    public void afisare(){
        List<PantofiSport> pantofiSports = pantofiSportService.gelAllPantofiSport();
        for (PantofiSport pantofiSport: pantofiSports){
            System.out.println(pantofiSport);
        }
    }
    public void addPantofiSport(){
        System.out.println("Introdu denumirea produsului:");
        String numeProdus= scanner.nextLine();
        System.out.println("Introdu descrierea produsului:");
        String descriere = scanner.nextLine();
        System.out.println("Introdu sku-ul produsului:");
        String sku = scanner.nextLine();
        System.out.println("Introdu culoarea produsului:");
        String culoare = scanner.nextLine();
        System.out.println("Introdu genul de incadrare a produsului:");
        String gen = scanner.nextLine();
        System.out.println("Introdu marimea produsului:");
        double marime = Double.parseDouble(scanner.nextLine());
        System.out.println("Introdu pretul produsului:");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Introdu cate bucati sunt in stoc:");
        int stoc = Integer.parseInt(scanner.nextLine());
        try {
            PantofiSport pantofiSport = PantofiSport.builder().numeProdus(numeProdus).descriere(descriere).sku(sku).culoare(culoare).gen(gen).marime(marime).price(price).stoc(stoc).build();
            pantofiSportService.addPantofiSport(pantofiSport);
            System.out.println("Ai adaugat o pereche de pantofi cu succes!!");
            System.out.println(pantofiSport);
        }catch (ExceptiePantofiSportExistent e){
            System.err.println(e.getMessage());
        }
    }
    public void removePantofiSport(){
        System.out.println("Introdu sku-ul produsului:");
        String sku = scanner.nextLine();
        try {
            pantofiSportService.removePantofiSport(sku);
            System.out.println("Ai sters un produs cu succes!!");
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void updatePantofSportPrice(){
        System.out.println("Introdu sku-ul produsului:");
        String sku = scanner.nextLine();
        System.out.println("introdu noul pret:");
        double price = Double.parseDouble(scanner.nextLine());
        try{
            pantofiSportService.updatePantofiSportPrice(price, sku);
            System.out.println("Ai updata produsul cu succes!!");
            System.out.println(pantofiSportService.findPantofiSport(sku));
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void updatePantofSportStoc(){
        System.out.println("Introdu sku-ul produsului:");
        String sku = scanner.nextLine();
        System.out.println("introdu noul stoc:");
        int stoc = Integer.parseInt(scanner.nextLine());
        try{
            pantofiSportService.updatePantofiSportStoc(stoc, sku);
            System.out.println("Ai updata produsul cu succes!!");
            System.out.println(pantofiSportService.findPantofiSport(sku));
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void updatePantofSportMarime(){
        System.out.println("Introdu sku-ul produsului:");
        String sku = scanner.nextLine();
        System.out.println("introdu noua marime:");
        double marime = Double.parseDouble(scanner.nextLine());
        try{
            pantofiSportService.updatePantofiSportMarime(marime, sku);
            System.out.println("Ai updata produsul cu succes!!");
            System.out.println(pantofiSportService.findPantofiSport(sku));
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }

    public void getPantofSportByNumeProdus(){
        try {
            List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByNumeProdus();
            for (PantofiSport pantofiSport : pantofiSports) {
                System.out.println(pantofiSport);
            }
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void getPantofSportByPriceA(){
        try {
            List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceA();
            for (PantofiSport pantofiSport : pantofiSports) {
                System.out.println(pantofiSport);
            }
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void getPantofSportByPriceD(){
        try {
            List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByPriceD();
            for (PantofiSport pantofiSport : pantofiSports) {
                System.out.println(pantofiSport);
            }
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void getPantofSportByGenM(){
        try {
            List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenM();
            for (PantofiSport pantofiSport : pantofiSports) {
                System.out.println(pantofiSport);
            }
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }
    public void getPantofSportByGenF(){
        try {
            List<PantofiSport> pantofiSports = pantofiSportService.getPantofiSportByGenF();
            for (PantofiSport pantofiSport : pantofiSports) {
                System.out.println(pantofiSport);
            }
        }catch (ExceptiePantofiSportNeexistent e){
            System.err.println(e.getMessage());
        }
    }

}
