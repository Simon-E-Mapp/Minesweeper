public class Cell {
    private boolean isVisible;
    private boolean isMine;
    private int nearbyMines;

    public Cell() {
        this.isVisible = false;
        this.isMine = false;
        this.nearbyMines = 0;
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
    public void setMine(boolean isMine){
        this.isMine = isMine;
    }
    public int getNearbyMines() {
        return nearbyMines;
    }
    public void setNearbyMines(int counter) {
        this.nearbyMines = counter;
    }
}

