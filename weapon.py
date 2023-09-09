class Weapon:
    def __init__(self, name, accuracy, dmg):
        self.name = name
        self.accuracy = accuracy
        self.dmg = dmg

    def getAccuracy(self):
        return self.accuracy
    
    def getDmg(self):
        return self.dmg
    
    def getName(self):
        return self.name



