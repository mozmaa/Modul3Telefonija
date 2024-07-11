INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (1, 'Potok 150', '150 min. 150 SMS, 2GB', 800);

INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (2, 'Potok 300', '300 min. 300 SMS, 2.5GB', 1200);
	
INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (3, 'Maslačak 12', 'neograničeni min., neograničeni SMS, 27GB', 1900);
	
INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (4, 'Maslačak 25', 'neograničeni min., neograničeni SMS, 40GB', 2300);
	
INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (5, 'Maslačak 50', 'neograničeni min., neograničeni SMS, 100GB', 2600);
	
INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (6, 'Vrabac lite', 'neograničeni min., neograničeni SMS, neograničeni GB', 3000);
	
INSERT INTO tarifa (id, naziv, opis, cena) 
	VALUES (7, 'Vrabac max', 'neograničeni min., neograničeni SMS, neograničeni GB, besplatni Phoebus', 4500);
	
INSERT INTO provajder (id, naziv, adresa)
	VALUES (1 , 'Yettel' , 'Janka Cmelika 15, Savino Selo');
	
INSERT INTO provajder (id, naziv, adresa)
	VALUES (2 , 'MTS' , 'Sonje Marinkovic 12, Vrbas');
	
INSERT INTO provajder (id, naziv, adresa)
	VALUES (3 , 'A1' , 'Laze Nancica 36, Novi Sad');
	
INSERT INTO pretplata (id, trajanje_ugovora, datum_pocetka, ime_korisnika, pretplatniciki_broj, provajder_id, tarifa_id)
	VALUES (1, 12, '2020-06-21 20:00' , 'Tamara' , '+3816214587458' , 1, 1);
	
INSERT INTO pretplata (id, trajanje_ugovora, datum_pocetka, ime_korisnika, pretplatniciki_broj, provajder_id, tarifa_id)
	VALUES (2, 24, '2020-07-21 20:00' , 'Momir' , '+381621211069' , 1 , 5);

INSERT INTO pretplata (id, trajanje_ugovora, datum_pocetka, ime_korisnika, pretplatniciki_broj, provajder_id, tarifa_id)
	VALUES (3, 6, '2020-08-21 20:00', 'Petar', '+381641354535' , 2, 2);
	
INSERT INTO pretplata (id, trajanje_ugovora, datum_pocetka, ime_korisnika, pretplatniciki_broj, provajder_id, tarifa_id)
	VALUES (4, 12, '2021-06-21 20:00' , 'Igor' , '+381697424544' , 2 , 6);
	
INSERT INTO pretplata (id, trajanje_ugovora, datum_pocetka, ime_korisnika, pretplatniciki_broj, provajder_id, tarifa_id)
	VALUES (5, 24, '2022-06-21 20:00' , 'Miroslav' , '+3812131241' , 3, 3);

