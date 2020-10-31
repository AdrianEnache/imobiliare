package com.sda.practical;

import com.mysql.cj.xdevapi.SessionFactory;
import com.sda.practical.enums.MenuTypeEnum;
import com.sda.practical.handler.DatabaseHandler;
import com.sda.practical.handler.KeyboardHandler;
import com.sda.practical.handler.ViewHandler;
import com.sda.practical.models.ImobilModel;
import com.sda.practical.models.UserModel;

public class ConsoleView {

    public void startApp() {
        ViewHandler viewHandler = new ViewHandler();
        KeyboardHandler keyboardHandler = new KeyboardHandler();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        SessionFactory sessionFactory = new SessionFactory();


        Integer option = 0;
        while (option != 5) {
            viewHandler.printMenu(MenuTypeEnum.MAIN_MENU);
            option = keyboardHandler.readInteger("Introduceti optiunea : ");

            switch (option) {
                case 1:
                    String prenume = keyboardHandler.readString("Prenume: ");
                    String nume = keyboardHandler.readString("Nume: ");
                    String parola = keyboardHandler.readString("Parola: ");
                    Integer idTipUser = databaseHandler.verifyUser(prenume, nume, parola);
                    if (idTipUser == 1) {
                        while (option != 7) {
                            viewHandler.printMenu(MenuTypeEnum.CLIENT_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    System.out.println("Pa Pa");
                                    break;
                                default:
                                    System.out.println("Nu cunoastem optiunea !");

                            }
                        }
                    } else if (idTipUser == 2) {
                        while (option != 5) {
                            viewHandler.printMenu(MenuTypeEnum.VANZATOR_USER);
                            option = keyboardHandler.readInteger("Introduceti optiunea : ");
                            switch (option) {

                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                case 5:
                                    System.out.println("Pa Pa");
                                    break;
                                default:
                                    System.out.println("Nu cunoastem optiunea !");
                            }
                        }
                    } else {
                        System.out.println("The user doesnt exist!");
                    }

                    //TODO de creat metoda de log in, printr-un query - done
                    //TODO sa prindem intr-un loop metoda de log in, - done

                    break;
                case 2:
                    UserModel user = new UserModel();
                    user.setName(keyboardHandler.readString("Add Name: "));
                    user.setSurname(keyboardHandler.readString("Add SurName: "));
                    user.setPassword(keyboardHandler.readString("Add Password: "));
                    user.setPhoneNumber(keyboardHandler.readString("Add PhoneNumber: "));
                    user.setEmail(keyboardHandler.readString("Add Email: "));

                    viewHandler.printMenu(MenuTypeEnum.USER_TYPE);
                    int userTypeId = keyboardHandler.readInteger("Choose a user type: ");
                    boolean iscorect = true;
                    while (iscorect) {
                        if (userTypeId == 2) {
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        } else if (userTypeId == 1) {
                            user.setUserTypeId(userTypeId);
                            iscorect = false;
                        } else {
                            userTypeId = keyboardHandler.readInteger("Choose a user type: ");
                            iscorect = true;
                        }
                    }

                    databaseHandler.createUser(user);
                    System.out.println("User created !");

                    break;

                //TODO - de realizat metoda de adaugat imobile, am inceput, trebuie finalizata
                case 3:
                    ImobilModel imobilModel = new ImobilModel();
                    imobilModel.setDataPostariiAnuntului(keyboardHandler.readDate());
                    imobilModel.setAnConstructie(keyboardHandler.readInteger("Add year: "));
                    imobilModel.setEtaj(keyboardHandler.readInteger("Add etaj: "));
                    imobilModel.setNumarCamere(keyboardHandler.readInteger("Add Numar camere: "));
                    imobilModel.setPret(keyboardHandler.readDouble("Add price: "));
                    imobilModel.setCoordonate(keyboardHandler.readString("Add coordonate: "));


                    break;

                case 5:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Nu cunoastem optiunea");
            }

        }


    }


}
