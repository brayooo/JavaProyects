package co.edu.uptc.pojos;

public class Root {

    private FigureInformation figureInformation;
    private PanelInformation panelInformation;
    private MyFile myFile;

    public Root() {
        figureInformation = new FigureInformation();
        panelInformation = new PanelInformation();
    }

    public FigureInformation getFigureInformation() {
        return figureInformation;
    }

    public void setFigureInformation(FigureInformation figureInformation) {
        this.figureInformation = figureInformation;
    }

    public PanelInformation getPanelInformation() {
        return panelInformation;
    }

    public void setPanelInformation(PanelInformation panelInformation) {
        this.panelInformation = panelInformation;
    }

    public MyFile getMyFile() {
        return myFile;
    }

    public void setMyFile(MyFile myFile) {
        this.myFile = myFile;
    }
}
