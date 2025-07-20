class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (hour % 12 + minutes / 60.0) * 30.0; 
        double m = minutes * 6.0; 
        double angle = Math.abs(h - m);
        return Math.min(angle, 360 - angle); 
    }
}
