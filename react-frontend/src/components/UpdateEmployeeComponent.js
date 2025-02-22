import React, { useState, useEffect } from 'react';
import { useHistory, useParams } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

const UpdateEmployeeComponent = () => {
    const { id } = useParams();
    const history = useHistory();
    const [employee, setEmployee] = useState({
        firstName: '',
        lastName: '',
        emailId: ''
    });

    useEffect(() => {
        EmployeeService.getEmployeeById(id).then((res) => {
            let employee = res.data;
            setEmployee({
                firstName: employee.firstName,
                lastName: employee.lastName,
                emailId: employee.emailId
            });
        });
    }, [id]);

    const updateEmployee = (e) => {
        e.preventDefault();
        EmployeeService.updateEmployee(employee, id).then(() => {
            history.push('/employees');
        });
    };

    const changeHandler = (e) => {
        const { name, value } = e.target;
        setEmployee((prevState) => ({
            ...prevState,
            [name]: value
        }));
    };

    const cancel = () => {
        history.push('/employees');
    };

    return (
        <div>
            <br />
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Update Employee</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label> First Name: </label>
                                    <input
                                        placeholder="First Name"
                                        name="firstName"
                                        className="form-control"
                                        value={employee.firstName}
                                        onChange={changeHandler}
                                    />
                                </div>
                                <div className="form-group">
                                    <label> Last Name: </label>
                                    <input
                                        placeholder="Last Name"
                                        name="lastName"
                                        className="form-control"
                                        value={employee.lastName}
                                        onChange={changeHandler}
                                    />
                                </div>
                                <div className="form-group">
                                    <label> Email Id: </label>
                                    <input
                                        placeholder="Email Address"
                                        name="emailId"
                                        className="form-control"
                                        value={employee.emailId}
                                        onChange={changeHandler}
                                    />
                                </div>

                                <button className="btn btn-success" onClick={updateEmployee}>
                                    Save
                                </button>
                                <button className="btn btn-danger" onClick={cancel} style={{ marginLeft: '10px' }}>
                                    Cancel
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default UpdateEmployeeComponent;
