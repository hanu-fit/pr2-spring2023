enum DogStatus {
	SLEEP,
	AWAKE
}

enum ManStatus {
	HURT,
	NORMAL
}

class Dog {
	public DogStatus status = DogStatus.SLEEP;

	public void bark() {
		System.out.println("Gooooo!!");
	}

	/**
	 * Dog will bite a man
	 * 
	 * @param Man man
	 * 
	 * @return Man man
	 */
	public Man bite(Man man) {
		if (man.status == ManStatus.NORMAL) {
			man.status = ManStatus.HURT;
		}
		System.out.println(man.status);
		man.shout();

		return man;
	}
}

class Man {
	public ManStatus status = ManStatus.NORMAL;

	/**
	 * Man will kick a dog
	 * 
	 * @param Dog dog
	 * 
	 * @return Dog dog
	 */
	public Dog kick(Dog dog) {
		if (dog.status == DogStatus.SLEEP) {
			dog.status = DogStatus.AWAKE;

		} else {
			dog.bite(this);
		}
		System.out.println(dog.status);
		dog.bark();
		return dog;
	}

	public void shout() {
		System.out.println("Fuckkkkkk!!");
	}
}

class Main {

	public static void main(String[] args) {
		Man man = new Man();
		Dog dog = new Dog();

		dog = man.kick(dog);
		dog = man.kick(dog);
	}
}