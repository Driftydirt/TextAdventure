class Character:
    def __init__(self, name, HP, ac, weapon):
        self.name = name
        self.HP = HP
        self.ac = ac
        self.weapon = weapon

    def lowerHP(self, damage):
        self.HP = self.HP - damage
        if self.HP <= 0:
            return "dead"
        return "living"
    
    def getHP(self):
        return self.HP
    
    def getAC(self):
        return self.ac
    
    def getWeapon(self):
        return self.weapon
        