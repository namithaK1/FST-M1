class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color

    def accelerate(self):
        print(self.manufacturer ," - ", self.model, " is moving")

    def stop(self):
        print(self.manufacturer ," - ", self.model, " has stopped")

kiger = Car("Renault", "Kiger", "2021", "Manual" , "White")
tiago = Car("Toyota", "Tiago", "2020", "Manual" , "Red")
kiaSeltos = Car("KIA", "Seltos", "2021", "Auto" , "Black")

kiger.accelerate()
kiger.stop()

tiago.accelerate()
tiago.stop()

kiaSeltos.accelerate()
kiaSeltos.stop()