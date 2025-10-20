from math import hypot

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def distance(self):
        return hypot(self.x, self.y)
    
    def distanceTo(self, p):
        return hypot(self.x - p.x, self.y - p.y)

def main():
    p = Point(4.5, 7.0)

    x = float(input("Enter x-coordinate: "))
    y = float(input("Enter x-coordinate: "))
    
    uPoint = Point(x, y)

    print(f"Distance from origin {uPoint.distance()}")
    print(f"Distance from (4.5, 7.0) {round(uPoint.distanceTo(p), 3)}")

if __name__ == "__main__": main()