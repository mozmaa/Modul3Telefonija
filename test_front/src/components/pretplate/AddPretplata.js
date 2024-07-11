import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import TestAxios from "../../apis/TestAxios"
import { FormSelect, Row } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"

export const AddPretplata = () => {


    const [tarife, setTarife] = useState([])
    const [provajderi, setProvajderi] = useState([])
    const [novaPretplata, setNovaPretplata] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        getProvajderi()
        getTarife()
    }, [])

    const getTarife = () => {
        TestAxios.get('/tarife')
            .then(res => {
                setTarife(res.data)
            }).catch(error => {
                alert('Doslo je do greske!')
            })
    }

    const getProvajderi = () => {
        TestAxios.get('/provajderi')
            .then(res => {
                setProvajderi(res.data)
            }).catch(error => {
                alert('Doslo je do greske!')
            })
    }

    const handleChange = (e) => {
        if(e.target.name === "datumPocetka"){
            let date = new Date()
             let datumPocetka = e.target.value + ' '  + date.getHours() + ':' + date.getMinutes()
             setNovaPretplata({ ...novaPretplata, [e.target.name]: datumPocetka })
             console.log(datumPocetka)
             return;
        }
        setNovaPretplata({ ...novaPretplata, [e.target.name]: e.target.value })
    }

    const addTask = () => {
        TestAxios.post('/pretplate', novaPretplata)
            .then(res => {
                alert('Uspesno dodavanje')
                navigate('/pretplate')
            }).catch(error => {
                alert('Doslo je do greske')
            })
    }

    return (

        <Row className="justify-content-center">
            <Col md={8}>
                <h1>Dodavanje</h1>
                <Form.Group>
                    <Form.Label>Ime korisnika</Form.Label>
                    <Form.Control type='text' name='imeKorisnika' onChange={(e) => handleChange(e)} ></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Pretplatnicki broj</Form.Label>
                    <Form.Control type='text' name='pretplatnicikiBroj' onChange={(e) => handleChange(e)} ></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Provajder</Form.Label>
                    <FormSelect name="provajderId" onChange={(e) => handleChange(e)}>
                        <option value=''>--</option>
                        {provajderi.map((provajder, index) => {
                            return (
                                <option key={index} value={provajder.id}>{provajder.naziv}</option>
                            )
                        })
                        }
                    </FormSelect>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Tarifa</Form.Label>
                    <FormSelect name="tarifaId" onChange={(e) => handleChange(e)}>
                        <option value=''>--</option>
                        {tarife.map((tarifa, index) => {
                            return (
                                <option key={index} value={tarifa.id}>{tarifa.naziv}</option>
                            )
                        })
                        }
                    </FormSelect>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Datum Pocetka</Form.Label>
                    <Form.Control type='date' name='datumPocetka' onChange={(e) => handleChange(e)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Trajanje ugovora</Form.Label>
                    <FormSelect name="trajanjeUgovora" onChange={(e) => handleChange(e)}>
                        <option value=''>--</option>
                        <option value='6'>6 meseci</option>
                        <option value='12'>12 meseci</option>
                        <option value='24'>24 meseca</option>
                        <option value='48'>48 meseca</option>
                        
                    </FormSelect>
                </Form.Group>
                <Button style={{ marginTop: 10, marginBottom: 10 }} onClick={addTask}>Dodaj</Button>
            </Col>
        </Row>
    )

}