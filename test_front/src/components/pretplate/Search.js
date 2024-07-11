import { Form, FormSelect } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Row } from "react-bootstrap"

export const Search = (props) => {


    const handleChange = (e) => {
        props.searchParamsCallback({...props.searchParams, [e.target.name]: e.target.value})
    }

    return (

        
            
        <Row className="justify-content-center">
            <Col md={8}>
                <Form.Group>
                    <Form.Label>Datum od</Form.Label>
                    <Form.Control type="date" name='datumPocetkaOd' onChange={(e) => handleChange(e)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Datum do</Form.Label>
                    <Form.Control type="date" name='datumPocetkaDo'   onChange={(e) => handleChange(e)}></Form.Control>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Sprint</Form.Label>
                    <FormSelect name="tarifaId" onChange={(e) => handleChange(e)}>
                        <option value=''>--</option>
                        {props.tarife.map((tarifa, index)=> {
                            return(
                                <option key={index} value={tarifa.id}>{tarifa.naziv}</option>
                            )
                        })
                    }   
                    </FormSelect>
                </Form.Group>
                <Button style={{ marginTop: 10, marginBottom: 10 }} onClick={() => props.getPretplateCallback(0)}>Search</Button>
            </Col>
        </Row>
    )
}