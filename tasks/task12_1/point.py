import math
from math import pow
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def distance(self):
        return math.sqrt(pow(self.x, 2) + pow(self.y, 2))
    
    def distanceTo(self, p):
        return math.sqrt(pow(self.x - p.x, 2) + pow(self.y - p.y,2))

def main():
    p = Point(4.5, 7.0)

    x = float(input("Enter x-coordinate: "))
    y = float(input("Enter x-coordinate: "))
    
    uPoint = Point(x, y)

    print(f"Distance from origin {uPoint.distance()}")
    print(f"Distance from (4.5, 7.0) {round(uPoint.distanceTo(p), 3)}")

if __name__ == "__main__": main()