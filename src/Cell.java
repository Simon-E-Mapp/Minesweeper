public class Cell {
    private boolean isVisible;
    private boolean isFlagged;
    private boolean isMine;

    public Cell() {
        this.isVisible = false;
        this.isFlagged = false;
        this.isMine = false;
    }
    public boolean isMine(){
        return  isMine;
    }
    public boolean isVisible(){
        return isVisible;
    }
    public void show(){
        this.isVisible = true;
    }
    public void flag(){
        this.isFlagged = true;
    }
    public void setMine(boolean isMine){
        this.isMine = isMine;
    }
}

